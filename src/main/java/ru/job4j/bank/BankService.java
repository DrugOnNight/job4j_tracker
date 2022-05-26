package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу Банка, в котором хранятся пользователи
 * и связанные с ними банковские счета
 * @author OLEG GODIZOV
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользоваеля и добавляет его в карту пользователей,
     * если такого пользователя нет.
     * @param user пользователь, которого добавляем в список.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из карты пользователей.
     * @param user пользователь, которого удаляем из списка.
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * Метод добавляет банковский аккаунт пользователю по паспорту.
     * @param passport паспорт пользователя, которому добаляем банковский аккаунт.
     * @param account банковский аккаунт, который добавляем пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод позволяет получить пользователя по паспорту.
     * @param passport паспорт по которому ищет пользователя.
     * @return возвращает пользователя с нужным паспортом или null, если такого нет.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет получить банковский аккаунт пользователя по реквизитам аккаунта.
     * @param passport паспорт пользователя по которому ищем счёт
     * @param requisite реквизиты аккаунта, который ищем
     * @return возвращает аккаунт или null, если такого нет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет перевести деньги с одного банковского счёта на другой.
     * @param srcPassport паспорт пользователя, который переводит деньги.
     * @param srcRequisite реквизиты счёта, с которого переводят деньги.
     * @param destPassport паспорт пользователя, которому переводят деньги.
     * @param destRequisite реквизиты счёта, на который переводят деньги.
     * @param amount сумма денег, которую перводят.
     * @return возвращает true, если перевод совершён и false, если перевод не удался.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}