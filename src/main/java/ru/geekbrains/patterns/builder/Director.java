package ru.geekbrains.patterns.builder;

public class Director {
    FoodBuilder builder;

    public void setBuilder(FoodBuilder builder) {
        this.builder = builder;
    }

    CookedFood buildCookedFood() {
        builder.createFood();
        builder.buildName();
        builder.buildTemperature();
        builder.buildMainIngredient();

        return builder.getCookedFood();
    }
}
