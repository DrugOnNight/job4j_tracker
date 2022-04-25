package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String skills;

    public Dentist(String name, String surname, String education, String birthday, int experience, String certificates) {
        super(name, surname, education, birthday, experience);
        this.skills = certificates;
    }

    public void deleteTooth(Patient patient) {
        if (skills.contains("Delete tooth")) {
            System.out.println("Deleting tooth");
        }
    }

}
