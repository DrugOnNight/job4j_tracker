package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.sort.ItemAscByName;
import ru.job4j.tracker.sort.ItemDescByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ItemTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Fix bug"));
        items.add(new Item("Debug program"));
        items.add(new Item("Cook food"));
        items.sort(new ItemAscByName());
        List<Item> excepted = new ArrayList<>();
        excepted.add(new Item("Cook food"));
        excepted.add(new Item("Debug program"));
        excepted.add(new Item("Fix bug"));
        assertThat(items, is(excepted));
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Cook food"));
        items.add(new Item("Fix bug"));
        items.add(new Item("Debug program"));
        items.sort(new ItemDescByName());
        List<Item> excepted = new ArrayList<>();
        excepted.add(new Item("Fix bug"));
        excepted.add(new Item("Debug program"));
        excepted.add(new Item("Cook food"));
        assertThat(items, is(excepted));
    }
}