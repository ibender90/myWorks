package ru.geekbrains.homework6;

public class Homework6 {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Сутулый");
        Cat cat1 = new Cat("Мракобес");

        dog1.run(200);
        cat1.run(100);

        dog1.swim(5);
        cat1.swim(1);

        System.out.println("Животных создано: "+ Animal.getAnimalCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
    }
}
