package ru.job4j.oop;

public class Calculator {

    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public int multiply(int a) {
        return X * a;
    }

    public static int minus(int y) {
        return y - X;
    }

    public int divide(int y) {
        return y / X;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int num = 10;
        System.out.println(sum(num));
        System.out.println(minus(num));
        System.out.println(calc.divide(num));
        System.out.println(calc.divide(num));
        System.out.println(calc.sumAllOperation(num));
    }

}