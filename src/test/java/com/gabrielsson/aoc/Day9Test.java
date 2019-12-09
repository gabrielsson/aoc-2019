package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day9Test {



    @Test
    public void part1() throws InterruptedException {
        PuzzleInput input = new PuzzleInput("day9.txt");
        Assert.assertEquals(2316632620l, new Day9().part1(input.getListOfSeparatedLong(",")));

    }

    @Test
    public void part2() throws InterruptedException {
        PuzzleInput input = new PuzzleInput("day9.txt");
        Assert.assertEquals(78869, new Day9().part2(input.getListOfSeparatedLong(",")));
    }

    @Test
    public void part1example() throws InterruptedException {

        Assert.assertEquals(1219070632396864l, new Day9().part1(Arrays.asList(1102,34915192,34915192,7,4,7,99).stream().map(Long::valueOf).collect(Collectors.toList())));

    }
    @Test
    public void part1exampleb() throws InterruptedException {

        Assert.assertEquals(1125899906842624l, new Day9().part1(Arrays.asList(104l,1125899906842624l,99l).stream().map(Long::valueOf).collect(Collectors.toList())));

    }
    @Test
    public void part1examplea() throws InterruptedException {

        Assert.assertEquals(109l, new Day9().part1(Arrays.asList(109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99).stream().map(Long::valueOf).collect(Collectors.toList())));

    }

    @Test
    public void longInput_lessThan8() throws InterruptedException {
        Assert.assertEquals(999l, new Day9().part1(Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
                1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
                999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99).stream().map(Long::valueOf).collect(Collectors.toList())));

        Assert.assertEquals(1l, new Day9().part1(Arrays.asList(3,0,4,0,99,0,0,0,0,0,0,0).stream().map(Long::valueOf).collect(Collectors.toList())));

    }
}