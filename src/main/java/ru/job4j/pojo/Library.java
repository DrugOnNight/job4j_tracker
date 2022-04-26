package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", 100);
        Book book2 = new Book("War and peace", 600);
        Book book3 = new Book("Tom Sawyer", 200);
        Book book4 = new Book("Clean code", 250);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getListsCount() + " pages");
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getListsCount() + " pages");
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " - " + books[i].getListsCount() + " pages");
            }
        }

    }
}
