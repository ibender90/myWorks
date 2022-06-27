package ru.geekbrains.patterns.factory;

public class StoreApp {
    public static void main(String[] args) {

        StoreFactory electronicStoreFactory = new ElectronicStoreFactory();
        Store euronics = electronicStoreFactory.createStore();
        euronics.sell();

        StoreFactory groceryFactory = new GroceryStoreFactory();
        Store maxima = groceryFactory.createStore();
        maxima.sell();
    }
}
