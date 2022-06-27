package ru.geekbrains.patterns.builder;

public class WaffleBuilder extends FoodBuilder{
    @Override
    void buildName() {
        cookedFood.setName("Waffle");
    }

    @Override
    void buildTemperature() {
        cookedFood.setTemperature(150);
    }

    @Override
    void buildMainIngredient() {
        cookedFood.setMainIngredient("Milk");
    }
}
