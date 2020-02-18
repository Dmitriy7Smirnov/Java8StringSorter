package com.nicedev;

        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "сапог сарай арбуз болт бокс биржа";
        TreeMap<Character, List<String>> sortedMap = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(s -> s.toLowerCase().charAt(0), Collectors.toList()))
                .entrySet().stream().filter(map -> map.getValue().size() > 1)
                .map(entry ->
                {entry.getValue().sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
                    return entry;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, TreeMap::new));

        String result = sortedMap
                .toString()
                .replaceAll("^\\{}", "[")
                .replaceAll("}$", "]");

        System.out.println(result);
    }
}
