package com.gabrielsson.aoc;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Day9 {
    private static final boolean USE_FEEDBACK = true;

    public Object part1(List<Long> listOfRows) throws InterruptedException {

        return runProgram(listOfRows, 1l);

    }

    public Object part2(List<Long> listOfRows) throws InterruptedException {

        return runProgram(listOfRows, 2l);

    }

    private static Long runProgram(List<Long> program, long val) throws InterruptedException {
        BlockingQueue<Long> input = new ArrayBlockingQueue<>(2);
        input.put(val);

        BlockingQueue<Long> output = new ArrayBlockingQueue<>(20);
        IntComp intComp = new IntComp(program, input, output);

        intComp.run();

        return intComp.getOut().peek();
    }
}
