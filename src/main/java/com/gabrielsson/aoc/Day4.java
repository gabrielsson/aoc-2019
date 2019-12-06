package com.gabrielsson.aoc;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Day4 {
    public static Object part1(int from, int to) {

        return IntStream.rangeClosed(from, to)
                .filter(i -> {
                    boolean matching = false;
                    String matchingLetter = null;
                    String[] numbers = String.valueOf(i).split("\\B");
                    for (int i1 = 1; i1 < numbers.length; i1++) {
                        //size
                        if (Integer.valueOf(numbers[i1 - 1]) > Integer.valueOf(numbers[i1])) return false;
                        String n = numbers[i1];
                        if (numbers[i1 - 1].equals(n)) {
                            matching = true;
                            if(matchingLetter == null) matchingLetter = n;
                            if (i1 > 1) {
                                if (numbers[i1 - 2].equals(n) && n.equals(matchingLetter)) {
                                    matching = false;
                                    matchingLetter = null;
                                }
                            }
                        }
                    }
                    return matching;

                }).count();

    }

    public static Object part2(List<String> listOfRows) {

        return "";

    }

}
