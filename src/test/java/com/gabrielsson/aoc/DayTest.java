package com.gabrielsson.adventofcode;//package com.gabrielsson.adventofcode;

import com.gabrielsson.aoc.Day;
import com.gabrielsson.aoc.PuzzleInput;
import org.junit.Assert;
import org.junit.Test;

public class DayTest {

    @Test
    public void part1example() {
        PuzzleInput input = new PuzzleInput("day.txt");


        Assert.assertEquals("", Day.part1(input.getListOfRows()));

    }

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day.txt");

        Day d = new Day();
        Assert.assertEquals("", d.part1(input.getListOfRows()));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day.txt");

        Day d = new Day();
        Assert.assertEquals("", d.part1(input.getListOfRows()));

    }
}