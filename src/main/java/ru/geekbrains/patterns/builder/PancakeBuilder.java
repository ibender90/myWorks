package ru.geekbrains.patterns.builder;

public class PancakeBuilder extends FoodBuilder{
    @Override
    void buildName() {
        cookedFood.setName("Pancake");
    }

    @Override
    void buildTemperature() {
        cookedFood.setTemperature(180);
    }

    @Override
    void buildMainIngredient() {
        cookedFood.setMainIngredient("SpoiledMilk");
    }
}
