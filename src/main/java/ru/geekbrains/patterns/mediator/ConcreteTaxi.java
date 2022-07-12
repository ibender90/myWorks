package ru.geekbrains.patterns.mediator;

public class ConcreteTaxi implements Taxi{

    private String name;
    private String status;
    private boolean busy;

    Mediator mediator;

    public ConcreteTaxi(String name, String status, boolean busy, Mediator mediator) {
        this.name = name;
        this.status = status;
        this.busy = busy;
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setBooked() {
        this.status = "booked";
        this.busy = true;
        System.out.println(this.name +  " : I am booked");
    }

    @Override
    public void setFree() {
        this.status = "free";
        this.busy = false;
        System.out.println("I am ready for a new trip");
    }

    @Override
    public void setRest() {
        this.status = "busy";
        this.busy = true;
        System.out.println(this.name + " is taking a break");
    }

    @Override
    public boolean getBusy() {
        return this.busy;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void assignDriver(Trip trip) {
        mediator.requestAll(trip);
    }
}
