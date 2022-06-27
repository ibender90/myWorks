package ru.geekbrains.patterns.factory;

public class ElectronicStoreFactory implements StoreFactory{
    @Override
    public Store createStore() {
        return new ElectronicsStore();
    }
}
