package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

public class Day6Test {

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day6example.txt");
        Assert.assertEquals(42l, new Day6().part1(input.getListOfRows()));
    }
    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day6example2.txt");
        Assert.assertEquals(4, new Day6().part2(input.getListOfRows()));
    }


    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day6.txt");
        Assert.assertEquals(417916l, new Day6().part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day6.txt");
        Assert.assertEquals(523, new Day6().part2(input.getListOfRows()));
    }
}