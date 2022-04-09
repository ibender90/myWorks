package ru.geekbrains.homework6;

public class Animal {
    private static int animalCount = 0;
    private int runAgility;
    private int swimAgility;
    private String name;

    protected Animal(String name) {
        this.name = name;
        animalCount++;
    }

    protected void run(int distance) {
        if (distance <= runAgility) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println("Слишком далеко");
        }
    }

    protected void swim(int distance) {
        if (distance <= swimAgility) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println("Слишком далеко");
        }
    }

    protected void setRunAgility(int runAgility) {
        this.runAgility = runAgility;
    }

    protected void setSwimAgility(int swimAgility) {
        this.swimAgility = swimAgility;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
