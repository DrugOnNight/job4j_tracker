package ru.job4j.inheritance;

public class Doctor extends Profession{

    private int experience;

    public Doctor() {

    }

    public Doctor(int experience) {
        super();
        this.experience = experience;
    }

    public Doctor(String name, String surname, String education, String birthday, int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    public void inspect(Patient patient) {
        String patientName = patient.getName();
        patient.getAge();
        patient.getComplaints();
        System.out.println("Пациент " + patientName + " осмотрен");
    }
}
