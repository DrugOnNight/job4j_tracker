package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean instruments;

    public Surgeon() {

    }

    public Surgeon(boolean instruments) {
        super();
        this.instruments = instruments;
    }

    public void heal(Patient patient, String diagnose) {
        if (instruments) {
            System.out.println("Healing patient...");
        }
    }

}
