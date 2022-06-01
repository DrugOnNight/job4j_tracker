package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет получить пользователя по паспорту.
     * @param passport паспорт по которому ищет пользователя.
     * @return возвращает пользователя с нужным паспортом или null, если такого нет.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет получить банковский аккаунт пользователя по реквизитам аккаунта.
     * @param passport паспорт пользователя по которому ищем счёт
     * @param requisite реквизиты аккаунта, который ищем
     * @return возвращает аккаунт или null, если такого нет.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(x -> x.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}