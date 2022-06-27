package ru.geekbrains.patterns.builder;

public class CookedFood {

    private String name;
    private int temperature;
    private String mainIngredient;

    @Override
    public String toString() {
        return "CookedFood{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                ", mainIngredient='" + mainIngredient + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

}
