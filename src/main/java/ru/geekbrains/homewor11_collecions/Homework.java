package ru.geekbrains.homewor11_collecions;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        String[] arrayOfWords = {
                "Создать", "массив", "с", "набором", "слов",
                "10", "20", "слов", "должны", "встречаться",
                "повторяющиеся", "найти", "и", "вывести",
                "список", "уникальных", "слов", "из", "которых",
                "состоит", "массив", "дубликаты", "не",
                "считаем", "Посчитать", "сколько", "раз",
                "встречается", "каждое", "слово"
        };

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(List.of(arrayOfWords)); // в сет добавятся только уникальные строки
        System.out.println(wordSet.size()); // вывожу количество элементов этого множества

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word :
                arrayOfWords) {
            if(wordMap.containsKey(word)) { //если слово уже встречалось
                int i = wordMap.get(word);  //достаю значение  (здесь значение = целое число)
                i++; //инкрементирую
                wordMap.put(word, i); //кладу новое значение для этого слова
            } else wordMap.put(word, 1); //если слово новое для мапы, передаю значение 1
        }
        System.out.println(wordMap); // вывожу в консоль сколько раз встречалось слово


        //второе задание
        PhoneBook.add("Smith", 1236357);
        PhoneBook.add("Evans", 12346632);
        PhoneBook.add("Smith", 234235666);

        PhoneBook.get("Smith");
        //PhoneBook.get("Evans");
    }


}
