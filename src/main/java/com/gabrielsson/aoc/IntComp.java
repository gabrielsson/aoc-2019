package com.gabrielsson.aoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class IntComp implements Runnable {

    private List<Long> program;
    private final BlockingQueue<Long> in;
    private final BlockingQueue<Long> out;
    int currentIndex = 0;
    private boolean verbose = true;
    private long relativeBase = 0l;

    public IntComp(List<Long> program, BlockingQueue<Long> in, BlockingQueue<Long> out) {
        this.program = new ArrayList<>();
        this.program.addAll(program);
        var memory = IntStream.range(0, 4000).boxed().map(i -> 0l).collect(Collectors.toList());
        this.program.addAll(memory);
        this.in = in;
        this.out = out;
    }

    public void run() {

        try {
            while (program.get(currentIndex) != 99l) {
                Operation o = new Operation(program.get(currentIndex));
                Long idx1 = 0l;
                if (program.size() > currentIndex + 1) {
                    idx1 = program.get(currentIndex + 1);
                }

                Long idx2 = 0l;
                if (program.size() > currentIndex + 2) {
                    idx2 = program.get(currentIndex + 2);
                }
                Long idx3 = 0l;
                if (program.size() > currentIndex + 3) {
                    idx3 = program.get(currentIndex + 3);

                }
                switch (o.getOperation()) {

                    case 1:
                        long a1 = getValue(o.getFirstMode(), idx1);
                        long a2 = getValue(o.getSecondMode(), idx2);
                        long sum = a1 + a2;
                        setValue(o.getThirdMode(), idx3, sum);
                        currentIndex += 4;
                        break;
                    case 2:

                        long m1 = getValue(o.getFirstMode(), idx1);
                        long m2 = getValue(o.getSecondMode(), idx2);
                        long prod = m1 * m2;
                        setValue(o.getThirdMode(), idx3, prod);
                        currentIndex += 4;

                        break;
                    case 3:
                        long input = in.poll(1, TimeUnit.HOURS);
                        if (verbose) {
                            System.out.println("input: " + input);
                        }
                        setValue(o.getFirstMode(), idx1, input);
                        currentIndex += 2;
                        break;
                    case 4:
                        long output = getValue(o.getFirstMode(), idx1);
                        if (verbose) {
                            System.out.println("output: " + output + " remaining cap: " + out.remainingCapacity());
                        }

                        out.put(output);
                        currentIndex += 2;
                        break;
                    case 5:
                        long jumpIfTrue = getValue(o.getFirstMode(), idx1);
                        if (jumpIfTrue != 0) {
                            Long address = getValue(o.getSecondMode(), idx2);
                            currentIndex = address.intValue();
                        } else {
                            currentIndex += 3;

                        }
                        break;
                    case 6:
                        long jumpIfFalse = getValue(o.getFirstMode(), idx1);
                        if (jumpIfFalse == 0) {
                            Long address = getValue(o.getSecondMode(), idx2);
                            currentIndex = address.intValue();
                        } else {
                            currentIndex += 3;

                        }
                        break;
                    case 7:
                        long l1 = getValue(o.getFirstMode(), idx1);
                        long l2 = getValue(o.getSecondMode(), idx2);

                        setValue(o.getThirdMode(), idx3, l1 < l2 ? 1l : 0l);
                        currentIndex += 4;

                        break;
                    case 8:
                        long g1 = getValue(o.getFirstMode(), idx1);
                        long g2 = getValue(o.getSecondMode(), idx2);

                        setValue(o.getThirdMode(), idx3, g1 == g2 ? 1l : 0l);
                        currentIndex += 4;

                        break;
                    case 9:
                        long value = getValue(o.getFirstMode(), idx1);
                        this.relativeBase += value;
                        currentIndex += 2;
                        break;
                    default:
                        throw new UnsupportedOperationException(o.getOperation() + " is not recognized.");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void setValue(int mode, Long idx, Long value) {
        Long index = null;
        if (mode == 0) index = idx;
        if (mode == 2) index = idx + relativeBase;
        program.set(Math.toIntExact(index), value);
    }

    private Long getValue(int mode, Long idx) {
        Long value = null;
        if (mode == 1) {
            value = idx;
        } else if (mode == 0) {
            value = program.get(idx.intValue());
        } else if (mode == 2) {
            value = program.get(Math.toIntExact(idx + relativeBase));
        }

        return value;
    }

    private static Integer getInstruction(List<Integer> currentPgm, int currentIndex) {
        if (currentPgm.size() < currentIndex) return -1;
        return currentPgm.get(currentIndex);
    }

    @Data
    static class Operation {

        private Integer operation;
        private int firstMode = 0;
        private int secondMode = 0;
        private int thirdMode = 0;

        /*
                public Operation(long code) {
                    String[] s = String.valueOf(code).split("\\B");
                    List<String> list = Arrays.asList(s);
                    Collections.reverse(list);

                    Integer[] codes = list.stream().mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);

                    this.setOperation(codes[0]);
                    if (codes.length > 2) this.setFirstMode(codes[2] > 0);
                    if (codes.length > 3) this.setSecondMode(codes[3] > 0);
                    if (codes.length > 4) this.setThirdMode(codes[4] > 0);
                }
        */
        public Operation(long code) {
            operation = (int) (code % 100);
            int modes = (int) (code / 100);

            firstMode = modes % 10;
            secondMode = (modes / 10) % 10;
            thirdMode = (modes / 100) % 10;
        }
    }
}
