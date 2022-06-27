package ru.geekbrains.patterns.factory;

public class ElectronicsStore implements Store{

    @Override
    public void sell() {
        System.out.println("selling computers");
    }

}
