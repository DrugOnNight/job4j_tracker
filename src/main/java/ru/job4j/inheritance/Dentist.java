package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String skills;

    public Dentist() {

    }

    public Dentist(String certificates) {
        super();
        this.skills = certificates;
    }

    public void deleteTooth(Patient patient) {
        if (skills.contains("Delete tooth")) {
            System.out.println("Deleting tooth");
        }
    }

}
