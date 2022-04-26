package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Oleg Godizov");
        student.setGroup("job4j-group2022");
        student.setAdmission(new Date());
        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getAdmission());
    }
}
