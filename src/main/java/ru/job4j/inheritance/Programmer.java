package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String languages;

    public Programmer(String name, String surname, String education, String birthday, boolean toolbox, boolean knowledge, String languages) {
        super(name, surname, education, birthday, toolbox, knowledge);
        this.languages = languages;
    }

    public void programming(String task, String language) {
        System.out.println("Programming on " + language + "...");
    }
}
