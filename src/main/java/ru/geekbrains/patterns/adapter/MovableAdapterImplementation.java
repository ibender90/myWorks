package ru.geekbrains.patterns.adapter;

public class MovableAdapterImplementation implements MovableAdapter {
    private Movable luxuryCar;

    public MovableAdapterImplementation(Movable luxuryCar) {
        this.luxuryCar = luxuryCar;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCar.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
