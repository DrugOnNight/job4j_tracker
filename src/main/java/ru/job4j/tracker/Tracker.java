package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] rsl = new Item[size];
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null) {
                rsl[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] rsl = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                rsl[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }
}