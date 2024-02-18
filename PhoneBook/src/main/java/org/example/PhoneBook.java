package org.example;

import java.util.*;

public class PhoneBook {
    private final HashMap<String, TreeSet<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        TreeSet<String> numbers = contacts.getOrDefault(name, new TreeSet<>());
        numbers.add(phoneNumber);
        contacts.put(name, numbers);
    }

    public void displayContacts() {
        // Создаем список записей из элементов HashMap
        List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(contacts.entrySet());

        // Сортируем список по убыванию числа телефонов
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, TreeSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        // Добавляем контакты
        phoneBook.addContact("Маша", "1234567890");
        phoneBook.addContact("Давид", "0987654321");
        phoneBook.addContact("Маша", "9876543210");
        phoneBook.addContact("Галя", "5555555555");
        phoneBook.addContact("Давид", "7777777777");
        phoneBook.addContact("Маша", "98765225763");

        // Выводим контакты
        phoneBook.displayContacts();
    }
}
