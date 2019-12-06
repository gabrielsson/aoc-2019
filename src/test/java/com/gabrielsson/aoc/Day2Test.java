package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Day2Test {

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day2.txt");
        Assert.assertEquals(3166704, Day2.part1(input.getListOfSeparatedIntegers(","), 12, 2));
    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day2.txt");
        Assert.assertEquals(8018, Day2.part2(input.getListOfSeparatedIntegers(",")));
    }

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day2.txt");
       Assert.assertEquals(30, Day2.part1(Arrays.asList(1,1,1,4,99,5,6,0,99),1,1));
    }
    @Test
    public void part1example2() {
        PuzzleInput input = new PuzzleInput("day2.txt");
        Assert.assertEquals(3500, Day2.part1(Arrays.asList(1,9,10,3,2,3,11,0,99,30,40,50),9,10));
    }

    @Test
    public void part1example3() {
        PuzzleInput input = new PuzzleInput("day2.txt");
        Assert.assertEquals(2, Day2.part1(Arrays.asList(2,4,4,5,99,0),4,4));
    }

}