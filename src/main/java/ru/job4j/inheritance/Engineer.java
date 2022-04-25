package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean toolbox;
    private boolean knowledge;

    public Engineer(String name, String surname, String education, String birthday, boolean toolbox, boolean knowledge) {
        super(name, surname, education, birthday);
        this.toolbox = toolbox;
        this.knowledge = knowledge;
    }

    public boolean fix() {
        return toolbox && knowledge;
    }
}
