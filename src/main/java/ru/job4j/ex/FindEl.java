package ru.job4j.ex;

import java.util.SimpleTimeZone;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == key) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"Oleg", "Petya", "Vanya"}, "O");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}