package com.nicedev;

import java.util.Comparator;

public class SorterByLength implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.length() == str2.length() ? str1.compareTo(str2) : str2.length() - str1.length();
    }
}
