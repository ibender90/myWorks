package ru.geekbrains.patterns.factory;

public class GroceryStore implements Store{
    @Override
    public void sell() {
        System.out.println("selling potato");
    }

}
