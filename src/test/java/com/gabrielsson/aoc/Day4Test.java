package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

public class Day4Test {
    @Test
    public void part1() {
        Assert.assertEquals("", Day4.part1(123257,647015));

    }

    @Test
    public void part1example() {
        Assert.assertEquals(0l, Day4.part1(223450,223450));
    }



    @Test
    public void part2a() {
        Assert.assertEquals(1l, Day4.part1(112233,112233));

    }

    @Test
    public void part2b() {
        PuzzleInput input = new PuzzleInput("day.txt");
        Assert.assertEquals(0l, Day4.part1(123444,123444));

    }

    @Test
    public void part2c() {
        PuzzleInput input = new PuzzleInput("day.txt");
        //Assert.assertEquals(1l, Day4.part1(111122,111122));
        Assert.assertEquals(1l, Day4.part1(111122,111122));

    }

    @Test
    public void part2d() {
        PuzzleInput input = new PuzzleInput("day.txt");
        //Assert.assertEquals(1l, Day4.part1(111122,111122));
        Assert.assertEquals(0l, Day4.part1(223450,223450));

    }


    @Test
    public void part2e() {
        PuzzleInput input = new PuzzleInput("day.txt");
        //Assert.assertEquals(1l, Day4.part1(111122,111122));
        Assert.assertEquals(1l, Day4.part1(219,239));

    }

    @Test
    public void part2f() {
        PuzzleInput input = new PuzzleInput("day.txt");
        //Assert.assertEquals(1l, Day4.part1(111122,111122));
        Assert.assertEquals(0l, Day4.part1(123789,123789));
    }
}