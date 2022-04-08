package ru.geekbrains.homework6;

public class Dog extends Animal{
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        setRunAgility(500);
        setSwimAgility(10);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
