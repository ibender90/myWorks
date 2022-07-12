package ru.geekbrains.patterns.mediator;

public interface Taxi {

    String getName();
    void setBooked();
    void setFree();
    void setRest();
    boolean getBusy();
    String getStatus();
    void assignDriver(Trip trip);
}
