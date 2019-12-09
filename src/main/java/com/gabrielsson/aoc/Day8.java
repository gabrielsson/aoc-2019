package com.gabrielsson.aoc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {
    public static Object part1(List<Integer> listOfRows, int width, int height) {

        List<ListInfo> layers = new ArrayList<>();
        for (int i = 0; i < listOfRows.size(); i = i + (width * height)) {
            List<Integer> integers = listOfRows.subList(i, i + (width * height));

            layers.add(new ListInfo(integers));
        }

        ListInfo listInfo = layers.stream()
                .sorted(Comparator.comparing(layer -> layer.getZero()))
                .findFirst().get();
        return listInfo.getOnes() * listInfo.getTwos();

    }

    public static Object part2(List<String> listOfRows, int width, int height) {
        List<char[][]> layers = new ArrayList<>();

        for (int r = 0; r < listOfRows.size(); r += width*height) {
            char[][] layer = getLayer(listOfRows.subList(r, r +(width * height)), width, height);
            layers.add(layer);
        }

        char[][] image = getTransparentImage(width, height);

        for (char[][] layer : layers) {
            for (char[] row : layer) {
                System.out.println(row);


            }
            System.out.println("row");
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (image[j][i] == '2') {
                        image[j][i] = getPixel(layer[j][i]);
                    }
                }
            }
        }

        for (char[] row : image) {
            System.out.println(row);

        }

        return "";

    }

    private static char[][] getTransparentImage(int width, int height) {
        char[][] image = new char[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                image[j][i] = '2';
            }
        }
        return image;
    }

    private static char[][] getLayer(List<String> integers, int width, int height) {
        int index = 0;
        char[][] layer = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                layer[i][j] = integers.get(index).charAt(0);
                index++;
            }
        }
        return layer;
    }

    private static char getPixel(char c) {
        if(c == '2') return '2';
        if(c == '1') return '|';
        if(c == '0') return ' ';
        return c;
    }

    private static char getCharacter(List<char[][]> layers, int j, int i) {

        Character character = layers.stream().map(chars -> chars[j][i]).filter(c -> !c.equals('2')).findFirst().get();
        return character.equals('0') ? ' ' : '▇';

    }

    @Data
    static
    class ListInfo {

        public ListInfo(List<Integer> list) {
            zero = list.stream().filter(integer -> integer.equals(0)).count();
            ones = list.stream().filter(integer -> integer.equals(1)).count();
            twos = list.stream().filter(integer -> integer.equals(2)).count();
            System.out.println(zero + ":" + (ones + twos));
        }

        private long zero;
        private long ones;
        private long twos;
    }

}
