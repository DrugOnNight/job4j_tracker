package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность ошибки: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение ошибки: " + message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 404, "Не найден файл");
        Error third = new Error(false, 302, "Доступ запрещён");
        first.printInfo();
        second.printInfo();
        third.printInfo();
    }
}
