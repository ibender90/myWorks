package ru.geekbrains.patterns.mediator;

public class TaxiApp {
    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteTaxi taxi1 = new ConcreteTaxi("Aleksandr", "busy", true, mediator);
        ConcreteTaxi taxi2 = new ConcreteTaxi("Nikolai", "free", false, mediator);
        ConcreteTaxi taxi3 = new ConcreteTaxi("Pavel", "busy", true, mediator);

        mediator.add(taxi1);
        mediator.add(taxi2);
        mediator.add(taxi3);

        Trip trip = new Trip(false, "Lennujaam");
        mediator.requestAll(trip);

    }
}
