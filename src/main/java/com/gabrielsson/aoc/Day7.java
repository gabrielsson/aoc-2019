package com.gabrielsson.aoc;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.paukov.combinatorics3.Generator;

import static java.util.stream.Collectors.toList;

public class Day7 {

    private static final boolean USE_FEEDBACK = true;

    public static Object part2(List<Long> listOfRows) {
        return Generator.permutation(5, 6, 7, 8, 9).simple().stream()
                .mapToLong(phases -> findLargestThrust(listOfRows, phases)).max().orElse(-1);

    }

    private static Long findLargestThrust(List<Long> program, List<Integer> phases) {
        try {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            List<BlockingQueue<Long>> wires = LongStream.rangeClosed(0, phases.size())
                    .mapToObj(c -> new ArrayBlockingQueue<Long>(2))
                    .collect(toList());
            if (USE_FEEDBACK) {
                wires.remove(wires.size() - 1);
                wires.add(wires.size(), wires.get(0));
            }
            for (int i = 0; i < phases.size(); i++) {
                wires.get(i).put(Long.valueOf(phases.get(i)));
                executor.execute(new IntComp(program, wires.get(i), wires.get(i + 1)));
            }
            wires.get(0).put(0l); // Initial Input
            executor.shutdown();
            executor.awaitTermination(1L, TimeUnit.DAYS);
            return wires.get(wires.size() - 1).poll(1, TimeUnit.HOURS);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
