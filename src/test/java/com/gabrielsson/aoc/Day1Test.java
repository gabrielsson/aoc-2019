package com.gabrielsson.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    @Test
    public void part1() {
        PuzzleInput input = new PuzzleInput("day1.txt");


        assertThat(Day1.part1(input.getListOfIntegers())).isEqualTo(3426455);
    }

    @Test
    public void part2() {
        PuzzleInput input = new PuzzleInput("day1.txt");

        assertThat(Day1.part2(input.getListOfIntegers())).isEqualTo(5136807);
    }


    @Test
    public void part2example() {
        assertThat(Day1.part2(Arrays.asList(1969))).isEqualTo(966);
    }

}