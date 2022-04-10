package ru.geekbrains.homework7;

public class Homework7 {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        {
            cats[0] = new Cat("Ginger", 25);
            cats[1] = new Cat("White", 30);
            cats[2] = new Cat("Black", 15);
            cats[3] = new Cat("Grey", 11);
            cats[4] = new Cat("Brown", 20);
        }

        Bowl catsBowl = new Bowl();
        catsBowl.addFood(100);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(catsBowl);
        }

        System.out.println("Remaining food " + catsBowl.getFoodAmount());

        catsBowl.addFood(10);
        cats[4].eat(catsBowl);
    }

}
