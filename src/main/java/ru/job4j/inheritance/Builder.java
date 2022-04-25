package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean helmet;

    public Builder() {

    }

    public Builder(boolean helmet) {
        super();
        this.helmet = helmet;
    }

    public void build(String task) {
        if (helmet) {
            System.out.println("Start building...");
        }
    }
}
