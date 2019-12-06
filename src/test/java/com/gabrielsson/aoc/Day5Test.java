package com.gabrielsson.aoc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Day5Test {


    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day5.txt");
        Assert.assertEquals(15508323, Day5.part1(input.getListOfSeparatedIntegers(","),1));

    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day5.txt");
        Assert.assertEquals(9006327, Day5.part1(input.getListOfSeparatedIntegers(","),5));
    }

    @Test
    public void part1example() {
        Assert.assertEquals(1000, Day5.part1(Arrays.asList(3,0,4,0,99,0,0,0,0,0,0,0),1000));
    }
    @Test
    public void part1example2() {
        Assert.assertEquals(3500, Day5.part1(Arrays.asList(1,11,12,3,2,3,13,0,4,0,99,30,40,50),0));
    }

    @Test
    public void part2example1() {
        Assert.assertEquals(1, Day5.part1(Arrays.asList(3,3,1107,-1,8,3,4,3,99,0,0,0,0),5));
    }

    @Test
    public void part2example2() {
        Assert.assertEquals(0, Day5.part1(Arrays.asList(3,9,8,9,10,9,4,9,99,-1,8,0,0,0,0,0),7));
    }

    @Test
    public void longInput_lessThan8() {
        Assert.assertEquals(999, Day5.part1(Arrays.asList(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99),5));
    }

    @Test
    public void longInput_greaterThan8() {
        Assert.assertEquals(1001, Day5.part1(Arrays.asList(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99),9));
    }

    @Test
    public void longInput_equals8() {
        Assert.assertEquals(1000, Day5.part1(Arrays.asList(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99),8));
    }


}