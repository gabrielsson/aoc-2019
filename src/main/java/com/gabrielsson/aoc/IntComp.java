package com.gabrielsson.aoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class IntComp implements Runnable {

    private List<Integer> program;
    private final BlockingQueue<Integer> in;
    private final BlockingQueue<Integer> out;
    int currentIndex = 0;
    private boolean verbose = true;


    public IntComp(List<Integer> program, BlockingQueue<Integer> in, BlockingQueue<Integer> out) {
        this.program = new ArrayList<>();
        this.program.addAll(program);
        this.in = in;
        this.out = out;
    }

    public void run() {


        try {
            while(program.get(currentIndex) != 99) {
                Operation o = new Operation(program.get(currentIndex));

                Integer idx1 = program.get(currentIndex + 1);

                Integer idx2 = program.get(currentIndex + 2);
                Integer idx3 = program.get(currentIndex + 3);
                switch (o.getOperation()) {

                    case 1:
                        int a1 = o.isFirstMode() ? idx1 : program.get(idx1);
                        int a2 = o.isSecondMode() ? idx2 : program.get(idx2);
                        int sum = a1 + a2;
                        program.set(idx3, sum);
                        currentIndex += 4;
                        break;
                    case 2:

                        int m1 = o.isFirstMode() ? idx1 : program.get(idx1);
                        int m2 = o.isSecondMode() ? idx2 : program.get(idx2);
                        int prod = m1 * m2;
                        program.set(idx3, prod);
                        currentIndex += 4;

                        break;
                    case 3:
                        Integer input = in.poll(1, TimeUnit.HOURS);
                        if(verbose) {
                            System.out.println("input: " + input);
                        }
                        program.set(idx1, input);
                        currentIndex += 2;
                        break;
                    case 4:
                        int output = o.isFirstMode() ? idx1 : program.get(idx1);
                        if(verbose) {
                            System.out.println("output: " + output);
                        }
                        out.put(output);
                        currentIndex += 2;
                        break;
                    case 5:
                        int jumpIfTrue = o.isFirstMode() ? idx1 : program.get(idx1);
                        if (jumpIfTrue != 0) {
                            int address = o.isSecondMode() ? idx2 : program.get(idx2);
                            currentIndex = address;
                        } else {
                            currentIndex += 3;

                        }
                        break;
                    case 6:
                        int jumpIfFalse = o.isFirstMode() ? idx1 : program.get(idx1);
                        if (jumpIfFalse == 0) {
                            int address = o.isSecondMode() ? idx2 : program.get(idx2);
                            currentIndex = address;
                        } else {
                            currentIndex += 3;

                        }
                        break;
                    case 7:
                        int l1 = o.isFirstMode() ? idx1 : program.get(idx1);
                        int l2 = o.isSecondMode() ? idx2 : program.get(idx2);

                        program.set(idx3, l1 < l2 ? 1 : 0);
                        currentIndex += 4;

                        break;
                    case 8:
                        int g1 = o.isFirstMode() ? idx1 : program.get(idx1);
                        int g2 = o.isSecondMode() ? idx2 : program.get(idx2);

                        program.set(idx3, g1 == g2 ? 1 : 0);
                        currentIndex += 4;

                        break;
                    default:
                        throw new UnsupportedOperationException(o.getOperation() + " is not recognized.");

                }
            }
        } catch (Throwable t) {

        }
    }

    private static Integer getInstruction(List<Integer> currentPgm, int currentIndex) {
        if (currentPgm.size() < currentIndex) return -1;
        return currentPgm.get(currentIndex);
    }

    @Data
    static class Operation {

        private Integer operation;
        private boolean firstMode = false;
        private boolean secondMode = false;
        private boolean thirdMode = false;

        public Operation(int code) {
            String[] s = String.valueOf(code).split("\\B");
            List<String> list = Arrays.asList(s);
            Collections.reverse(list);

            Integer[] codes = list.stream().mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);

            this.setOperation(codes[0]);
            if (codes.length > 2) this.setFirstMode(codes[2] > 0);
            if (codes.length > 3) this.setSecondMode(codes[3] > 0);
            if (codes.length > 4) this.setThirdMode(codes[4] > 0);
        }

    }
}
