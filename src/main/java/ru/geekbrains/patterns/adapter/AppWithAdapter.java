package ru.geekbrains.patterns.adapter;

public class AppWithAdapter {
    public static void main(String[] args) {

        BMWX3 bmw = new BMWX3();
        MovableAdapterImplementation adapter = new MovableAdapterImplementation(bmw);
        System.out.println(adapter.getSpeed()); //150 MPH will be converted to 241 KM/h
    }
}
