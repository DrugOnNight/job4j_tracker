package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        List<String> rsl = new ArrayList<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += "/" + el;
                tmp.add(start);
            }
        }
        for (String dep : tmp) {
            rsl.add(dep.substring(1));
        }
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
