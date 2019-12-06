package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

public class Day3Test {

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day3example.txt");
        Assert.assertEquals(159, new Day3().part1(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day3.txt");
        Assert.assertEquals(446, new Day3().part1(input.getListOfRows()));
    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day3.txt");
        Assert.assertEquals(9006, new Day3().part2(input.getListOfRows()));
    }
}