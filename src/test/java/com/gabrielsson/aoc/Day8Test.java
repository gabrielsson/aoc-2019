package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

public class Day8Test {

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day8.txt");
        Assert.assertEquals("", Day8.part1(input.getListOfNonSeparatedIntegers(), 25, 6));
    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day8.txt");
        Assert.assertEquals("", Day8.part1(input.getListOfNonSeparatedIntegers(), 25, 6));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day8.txt");
        Assert.assertEquals("", Day8.part2(input.getListOfSeparatedStrings("\\B"), 25, 6));
    }


    @Test
    public void part2example() {
        PuzzleInput input = new PuzzleInput("day8example.txt");
        Assert.assertEquals("", Day8.part2(input.getListOfSeparatedStrings("\\B"), 2, 2));
    }
}