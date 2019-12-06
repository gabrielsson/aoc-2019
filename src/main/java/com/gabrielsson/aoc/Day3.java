package com.gabrielsson.aoc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {
    public Object part1(List<String> listOfRows) {
        List<Point> wire1 = getPoints(listOfRows.get(0).split(","));
        List<Point> wire2 = getPoints(listOfRows.get(1).split(","));
        List<Point> intersects = getIntersectsBetween((List<Point>) wire1, (List<Point>) wire2);

        return getManhattanDistance(new Point(0, 0), intersects.get(0));
    }

    private List<Point> getIntersectsBetween(List<Point> wire1, List<Point> wire2) {
        return wire1.stream()
                .filter(p -> !p.equals(new Point(0, 0)))
                .filter(wire2::contains)
                .sorted(Comparator.comparingInt(p -> getManhattanDistance(new Point(0, 0), p)))
                .collect(Collectors.toList());
    }


    private List<Point> getPoints(String[] wire) {
        List<Point> p = new ArrayList<>();
        p.add(new Point(0, 0));

        for (String d : wire) {
            Point last = p.get(p.size() - 1);
            int number = Integer.parseInt(d.substring(1));
            IntConsumer consumer;
            switch (d.substring(0, 1)) {
                case "R": // right, increase x
                    consumer = i -> p.add(new Point(last.getX() + i, last.getY()));
                    break;
                case "U": // up increase y
                    consumer = i -> p.add(new Point(last.getX(), last.getY() + i));
                    break;
                case "D": // down decrease y
                    consumer = i -> p.add(new Point(last.getX(), last.getY() - i));
                    break;
                case "L": // left decrease x
                    consumer = i -> p.add(new Point(last.getX() - i, last.getY()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + d.substring(0, 1));
            }
            IntStream.rangeClosed(1, number).forEach(consumer);
        }
        return p;
    }

    public Object part2(List<String> listOfRows) {

        List<Point> wire1 = getPoints(listOfRows.get(0).split(","));
        List<Point> wire2 = getPoints(listOfRows.get(1).split(","));
        return getIntersectsBetween(wire1, wire2).stream()
                .mapToInt(p -> wire1.indexOf(p) + wire2.indexOf(p))
                .sorted()
                .findFirst()
                .getAsInt();
    }

    public static Integer getManhattanDistance(Point p1, Point p2) {
        int distance = 0;
        distance += Math.abs(p1.getX() - p2.getX());
        distance += Math.abs(p1.getY() - p2.getY());
        return distance;
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    class Point {
        int x;
        int y;
    }

}
