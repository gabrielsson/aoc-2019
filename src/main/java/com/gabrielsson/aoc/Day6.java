package com.gabrielsson.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day6 {

    public Object part1(List<String> listOfRows) {
        Map<String, String> objects = new HashMap<>();
        listOfRows.forEach(pair -> {
            String first = pair.substring(0, pair.indexOf(")"));
            String second = pair.substring(pair.indexOf(")") + 1);
            objects.put(second, first);
        });

        Set<String> keys = objects.keySet();

        long count = 0;

        for (String key : keys) {
            boolean hasResult = false;

            while (!hasResult) {
                if (!objects.containsKey(key)) {
                    hasResult = true;
                } else {
                    key = objects.get(key);
                    count++;
                }

            }
        }
        return count;

    }

    public Object part2(List<String> listOfRows) {

        Map<String, String> objects = new HashMap<>();
        listOfRows.forEach(pair -> {
            String first = pair.substring(0, pair.indexOf(")"));
            String second = pair.substring(pair.indexOf(")") + 1);
            objects.put(second, first);
        });

        Set<String> keys = objects.keySet();

        String youAreOrbiting = objects.get("YOU");
        String sanIsOrbiting = objects.get("SAN");
        long count = 0;
        List<String> you = new ArrayList<>();
        List<String> san = new ArrayList<>();

        you = getList(objects, youAreOrbiting);
        san = getList(objects, sanIsOrbiting);

        for(String key : you) {
            if(san.contains(key)){
                return you.indexOf(key) +1 + san.indexOf(key) +1;
            }
        }
        return count;

    }

    private List<String> getList(Map<String, String> objects, String youAreOrbiting) {
        List<String> list = new ArrayList<>();
        boolean hasResult = false;

        while (!hasResult) {
            if (!objects.containsKey(youAreOrbiting)) {
                hasResult = true;
            } else {
                youAreOrbiting = objects.get(youAreOrbiting);
                list.add(youAreOrbiting);
            }

        }

        return list;
    }

}


