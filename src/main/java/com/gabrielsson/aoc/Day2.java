package com.gabrielsson.aoc;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static Object part1(List<Integer> listOfRows, int noun, int verb) {
        return runProgram(listOfRows, noun, verb).get(0);
    }

    public static Object part2(List<Integer> listOfRows) {
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                List<Integer> currentPgm = runProgram(listOfRows, noun, verb);

                long answer = currentPgm.get(0);
                if (answer == 19690720) return 100 * noun + verb;
            }
        }

        return 0;
    }

    private static List<Integer> runProgram(List<Integer> program, int noun, int verb) {
        List<Integer> currentPgm = new ArrayList(program);

        currentPgm.set(1, noun);
        currentPgm.set(2, verb);
        int currentIndex = 0;

        while (currentPgm.get(currentIndex) != 99) {
            try {


                Integer idx1 = currentPgm.get(currentIndex + 1);
                Integer idx2 = currentPgm.get(currentIndex + 2);
                Integer outputPos = currentPgm.get(currentIndex + 3);

                switch (currentPgm.get(currentIndex)) {

                    case 1:
                        int sum = currentPgm.get(idx1) + currentPgm.get(idx2);
                        currentPgm.set(outputPos, sum);
                        break;
                    case 2:

                        int prod = currentPgm.get(idx1) * currentPgm.get(idx2);
                        currentPgm.set(outputPos, prod);
                        break;

                }
                currentIndex = currentIndex + 4;
            } catch (Exception e) {
                break;
            }
        }
        return currentPgm;
    }



}
