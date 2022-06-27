package ru.geekbrains.patterns.factory;

public class GroceryStoreFactory implements StoreFactory{
    @Override
    public Store createStore() {
        return new GroceryStore();
    }
}
