package ru.job4j.poly2;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("Передвигаемся по рельсам...");
    }
}
