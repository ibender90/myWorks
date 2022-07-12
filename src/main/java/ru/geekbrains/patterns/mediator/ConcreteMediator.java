package ru.geekbrains.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    List<Taxi> taxis = new ArrayList<>();

    void add(Taxi taxi) {
        taxis.add(taxi);
    }

    @Override
    public void requestAll(Trip trip) {
        for (Taxi taxiToDrive :
                taxis) {
            if (!taxiToDrive.getBusy() && !trip.isAssignedTrip()) {
                trip.setAssignedTrip(true);
                System.out.println("\n Trip to " + trip.getAddress() + " assigned on " + taxiToDrive.getName() + ".");
                taxiToDrive.setBooked();
                break;
            }
        }
        if(!trip.isAssignedTrip()){
            System.out.println("\n All taxis are busy for: " + trip.getAddress()+ " Please wait." );
        }
    }
}
