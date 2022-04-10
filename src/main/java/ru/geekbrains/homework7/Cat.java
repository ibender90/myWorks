package ru.geekbrains.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }

    public void eat(Bowl bowl){
        if(isEnoughFood(bowl)) {

            bowl.decreaseFood(appetite);
            isHungry = false;
            System.out.printf("Cat %s has eaten %d food, he is not hungry now\n", name, appetite);

        } else {
            System.out.println("Not enough food for such hungry cat! " + name + " is staring at you");
        }
    }

    private boolean isEnoughFood(Bowl bowl){
        return bowl.getFoodAmount() - appetite > 0;
    }
}
