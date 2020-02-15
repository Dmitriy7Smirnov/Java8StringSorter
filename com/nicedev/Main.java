package com.nicedev;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "сапог сарай арбуз болт бокс биржа";
        Map<Character, ArrayList<String>> sortedMap = Arrays.stream(str.split("\\s+"))
            .reduce(new HashMap<Character, ArrayList<String>>(), (accMap, word) -> {
                Character character = word.toLowerCase().charAt(0);
                accMap.computeIfAbsent(character, key -> new ArrayList<String>());
                accMap.get(character).add(word);
                return accMap;
            }, (map1, map2) -> null)
            .entrySet().stream().filter(map3 -> map3.getValue().size() > 1)
            .map(entry ->
                {entry.getValue().sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
                return entry;
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        String result = sortedMap
                            .toString()
                            .replaceAll("^\\{}", "[")
                            .replaceAll("}$", "]");

        System.out.println(result);
    }
}
