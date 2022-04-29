package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров = " + count);
    }

    @Override
    public float refuel(float fuel) {
        System.out.println("Идёт заправка...");
        System.out.println("Стоимость заправки: " + fuel * 50);
        return fuel * 50;
    }
}
