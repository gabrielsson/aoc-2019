package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

public class Day9Test {

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day9example.txt");
        Assert.assertEquals("", new Day9().part1(input.getListOfRows()));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day9.txt");
        Assert.assertEquals("", new Day9().part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day9.txt");
        Assert.assertEquals("", new Day9().part2(input.getListOfRows()));
    }
}