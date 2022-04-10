package ru.geekbrains.homework7;

public class Bowl {
    private int foodAmount;

    public void addFood(int amount){
        this.foodAmount += amount;
        System.out.printf("Food increased by %d pts, there is now %d\n", amount, foodAmount);
    }

    public void decreaseFood(int amount) {
        this.foodAmount -= amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
