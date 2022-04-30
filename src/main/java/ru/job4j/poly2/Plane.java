package ru.job4j.poly2;

public class Plane implements Vehicle{
    @Override
    public void move() {
        System.out.println("Летим по воздуху...");
    }
}
