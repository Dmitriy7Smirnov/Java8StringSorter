package com.nicedev;

import java.util.*;
import java.util.stream.Collectors;

public class MainOld {
    public MainOld() {
        String str = "Сапог сарай арбуз болт бокс биржа";
        String[] strings = str.split("\\s+");
        Collection<String> stringCollection = Arrays.asList(strings);
        //Stream<String> stringStream =
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        //ArrayList<String> list = new ArrayList<>();
        stringCollection.stream()
                .reduce(map, (map1, element) -> {
                    Character character = element.toLowerCase().charAt(0);
                    map1.computeIfAbsent(character, key -> new ArrayList<String>());
                    map1.get(character).add(element);
                    //map1.computeIfPresent(character, (key, value) -> { value.add(element); return value; });
                    System.out.println(map1);
                    return map; }, (map1, map2) -> { System.out.println("combine: map1 = " + map1.toString() + "; map2 = " + map2.toString() + "\n"); return null; } );

        Map<Character, ArrayList<String>> filtredMap = map.entrySet().stream().filter(map1 -> map1.getValue().size() > 1).collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
        System.out.println(filtredMap);

        Map<Character, ArrayList<String>> MapWihtSortedArrays = filtredMap.entrySet().stream()
                .map(entry -> {entry.getValue().sort(new SorterByLength()); return entry; })
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));

        System.out.println(MapWihtSortedArrays);

        Map<Character, ArrayList<String>> sortedMap = filtredMap
                .entrySet()
                .stream().sorted((entry1, entry2) -> entry1.getKey().toString().toLowerCase().compareTo(entry2.getKey().toString().toLowerCase()))
                .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));

        System.out.println(sortedMap);
    }
}
