package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Fix bug"));
        items.add(new Item("Debug program"));
        items.add(new Item("Cook food"));
        Collections.sort(items, new ItemAscByName());
        List<Item> excepted = new ArrayList<>();
        excepted.add(new Item("Cook food"));
        excepted.add(new Item("Debug program"));
        excepted.add(new Item("Fix bug"));
        Assert.assertEquals(excepted, items);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Cook food"));
        items.add(new Item("Fix bug"));
        items.add(new Item("Debug program"));
        Collections.sort(items, new ItemDescByName());
        List<Item> excepted = new ArrayList<>();
        excepted.add(new Item("Fix bug"));
        excepted.add(new Item("Debug program"));
        excepted.add(new Item("Cook food"));
        Assert.assertEquals(excepted, items);
    }
}