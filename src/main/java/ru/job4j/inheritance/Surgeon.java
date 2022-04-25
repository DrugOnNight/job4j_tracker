package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean instruments;

    public Surgeon(String name, String surname, String education, String birthday, int experience, boolean instruments) {
        super(name, surname, education, birthday, experience);
        this.instruments = instruments;
    }

    public void heal(Patient patient, String diagnose) {
        if (instruments) {
            System.out.println("Healing patient...");
        }
    }

}
