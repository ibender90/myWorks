package ru.geekbrains.patterns.builder;

public abstract class FoodBuilder {

    CookedFood cookedFood;

    void createFood(){
        cookedFood = new CookedFood();
    }

    abstract void buildName();
    abstract void buildTemperature();
    abstract void buildMainIngredient();

    CookedFood getCookedFood(){
        return cookedFood;
    }
}
