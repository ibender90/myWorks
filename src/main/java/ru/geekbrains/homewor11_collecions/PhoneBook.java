package ru.geekbrains.homewor11_collecions;

import java.util.*;
//всё статика, сосредоточился на коллекциях
public class PhoneBook {
    private static Map<String, LinkedList<Integer>> book = new HashMap<>();

    public static void add(String surname, int number){
        surname = surname.toLowerCase(Locale.ROOT); //toLowerCase чтобы не было ошибок
        if(book.containsKey(surname)){
            LinkedList<Integer> numbers = book.get(surname);
            numbers.add(number);
            book.replace(surname, numbers);
        } else{
            LinkedList<Integer> listOfNumbers = new LinkedList<>();
            listOfNumbers.add(number);
            book.put(surname, listOfNumbers);
        }
    }

    public static void get(String surname){ // сделал печать в консоль, так как в задании не уточняется как выводить данные и куда
        LinkedList<Integer> numbers = book.get(surname.toLowerCase(Locale.ROOT));
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
