package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean helmet;

    public Builder(String name, String surname, String education, String birthday, boolean toolbox, boolean knowledge, boolean helmet) {
        super(name, surname, education, birthday, toolbox, knowledge);
        this.helmet = helmet;
    }

    public void build(String task) {
        if (helmet) {
            System.out.println("Start building...");
        }
    }
}
