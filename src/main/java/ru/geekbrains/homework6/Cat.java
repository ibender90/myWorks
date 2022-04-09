package ru.geekbrains.homework6;

public class Cat extends Animal {
    private static int catCount = 0;

    protected Cat(String name) {
        super(name);
        this.setRunAgility(200);
        catCount++;
    }

    @Override
    protected void swim(int distance) {
        System.out.println("Кот отказывается плыть");
    }

    public static int getCatCount() {
        return catCount;
    }
}
