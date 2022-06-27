package ru.geekbrains.patterns.builder;

public class BuilderApp {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new PancakeBuilder());

        CookedFood cookedFood = director.buildCookedFood();

        System.out.println(cookedFood);

        director.setBuilder(new WaffleBuilder());
        System.out.println(director.buildCookedFood());
    }
}
