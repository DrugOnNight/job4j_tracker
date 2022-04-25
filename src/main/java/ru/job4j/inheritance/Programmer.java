package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String languages;

    public Programmer() {

    }

    public Programmer(String languages) {
        super();
        this.languages = languages;
    }

    public void programming(String task, String language) {
        System.out.println("Programming on " + language + "...");
    }
}
