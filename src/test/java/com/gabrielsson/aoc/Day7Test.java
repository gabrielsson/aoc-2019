package com.gabrielsson.aoc;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day7Test {

    @Test
    public void part1example() {
        /*
        Assert.assertEquals(43210, Day7.part1(Arrays.asList(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99,
                0, 0)));
*/
    }

    @Test
    public void part2example() {

        Assert.assertEquals(139629729l, new Day7().part2(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,
                27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5).stream().map(Long::valueOf).collect(Collectors.toList())));

    }
/*
    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day7.txt");
        Assert.assertEquals(70597, Day7.part1(input.getListOfSeparatedIntegers(",")));

    }
*/
    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day7.txt");
        Assert.assertEquals(30872528l, new Day7().part2(input.getListOfSeparatedLong(",")));
    }

}