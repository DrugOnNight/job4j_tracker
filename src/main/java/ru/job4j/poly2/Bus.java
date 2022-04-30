package ru.job4j.poly2;

public class Bus implements Vehicle{
    @Override
    public void move() {
        System.out.println("Едем по скоростным трассам...");
    }
}
