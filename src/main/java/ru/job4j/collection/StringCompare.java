package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            int compare = Integer.compare(left.charAt(i), right.charAt(i));
            if (compare != 0) {
                rsl = compare;
                break;
            }
        }
        if (left.length() != right.length() && rsl == 0) {
            rsl = left.length() - right.length();
        }
        return rsl;
    }
}