package ru.job4j.pojo;

public class Book {
    private String name;
    private int listsCount;

    public Book(String name, int listsCount) {
        this.name = name;
        this.listsCount = listsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListsCount() {
        return listsCount;
    }

    public void setListsCount(int listsCount) {
        this.listsCount = listsCount;
    }
}
