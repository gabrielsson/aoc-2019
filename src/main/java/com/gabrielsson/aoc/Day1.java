package com.gabrielsson.aoc;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Day1 {


    public static Object part1(List<Integer> input) {
        return input.stream().mapToInt(i -> i)
                .map(i -> i/3 -2)
                .filter(i->i>0)
                .sum();
    }


    public static Object part2(List<Integer> input) {
        return input.stream().mapToInt(i -> i)
                .map(Day1::calcFuels)
                .sum();

    }
    private static int calcFuels(int i) {
        int sum = i / 3 ;
        sum -= 2;
        if(sum > 0) {
            sum += calcFuels(sum);
        } else {
            sum = 0;
        }
        return sum;
    }
}
