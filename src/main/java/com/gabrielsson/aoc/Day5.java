package com.gabrielsson.aoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day5 {
    public static int part1(List<Integer> listOfRows, int input) {
        return runProgram(listOfRows, input);
    }

    public static Object part2(List<Integer> listOfRows) {

        return 0;
    }

    private static int runProgram(List<Integer> program, int input) {
        List<Integer> currentPgm = new ArrayList(program);
        int output = 0;

        int currentIndex = 0;

        while (currentPgm.get(currentIndex) != 99) {
            try {

                Operation o = new Operation(currentPgm.get(currentIndex));

                Integer idx1 = currentPgm.get(currentIndex + 1);
                Integer idx2 = currentPgm.get(currentIndex + 2);
                Integer idx3 = currentPgm.get(currentIndex + 3);
                switch (o.getOperation()) {

                    case 1:
                        int a1 = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        int a2 = o.isSecondMode() ? idx2 : currentPgm.get(idx2);
                        int sum = a1 + a2;
                        currentPgm.set(idx3, sum);
                        currentIndex = currentIndex + 4;
                        break;
                    case 2:

                        int m1 = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        int m2 = o.isSecondMode() ? idx2 : currentPgm.get(idx2);
                        int prod = m1 * m2;
                        currentPgm.set(idx3, prod);
                        currentIndex = currentIndex + 4;

                        break;
                    case 3:
                        currentPgm.set(idx1, input);
                        currentIndex = currentIndex + 2;
                        break;
                    case 4:
                        output = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        currentIndex = currentIndex + 2;
                        break;
                    case 5:
                        int jumpIfTrue = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        if (jumpIfTrue != 0) {
                            int address = o.isSecondMode() ? idx2 : currentPgm.get(idx2);
                            currentIndex = address;
                        } else {
                            currentIndex = currentIndex + 3;

                        }
                        break;
                    case 6:
                        int jumpIfFalse = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        if (jumpIfFalse == 0) {
                            int address = o.isSecondMode() ? idx2 : currentPgm.get(idx2);
                            currentIndex = address;
                        } else {
                            currentIndex = currentIndex + 3;

                        }
                        break;
                    case 7:
                        int l1 = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        int l2 = o.isSecondMode() ? idx2 : currentPgm.get(idx2);

                        currentPgm.set(idx3, l1 < l2 ? 1 : 0);
                        currentIndex = currentIndex + 4;

                        break;
                    case 8:
                        int g1 = o.isFirstMode() ? idx1 : currentPgm.get(idx1);
                        int g2 = o.isSecondMode() ? idx2 : currentPgm.get(idx2);

                        currentPgm.set(idx3, g1 == g2 ? 1 : 0);
                        currentIndex = currentIndex + 4;

                        break;

                }
            } catch (Exception e) {
                break;
            }
        }
        return output;
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
