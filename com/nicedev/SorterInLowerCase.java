package com.nicedev;

import java.util.Comparator;

public class SorterInLowerCase implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.toLowerCase().compareTo(str2.toLowerCase());
    }
}
