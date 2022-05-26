package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("user1@mail.ru", "Godizov Oleg");
        users.put("user2@mail.ru", "Ivan Ivanov");
        for (String key : users.keySet()) {
            System.out.println(users.get(key));
        }
    }
}
