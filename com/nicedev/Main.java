package com.nicedev;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "сапог сарай арбуз болт бокс биржа";
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        Map<Character, ArrayList<String>> sortedMap = Arrays.asList(str.split("\\s+")).stream()
                .reduce(map, (map1, element) -> {
                    Character character = element.toLowerCase().charAt(0);
                    map1.computeIfAbsent(character, key -> new ArrayList<String>());
                    map1.get(character).add(element);
                    return map; }, (map1, map2) -> { System.out.println("combine: map1 = " + map1.toString() + "; map2 = " + map2.toString() + "\n"); return null; } )
                .entrySet().stream().filter(map3 -> map3.getValue().size() > 1)
                .map(entry -> {entry.getValue().sort(new SorterByLength()); return entry;})
                .sorted((entry1, entry2) -> entry1.getKey().toString().toLowerCase().compareTo(entry2.getKey().toString().toLowerCase()))
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));

        System.out.println(sortedMap.toString().replace("{", "[").replace("}", "]"));
    }
}
