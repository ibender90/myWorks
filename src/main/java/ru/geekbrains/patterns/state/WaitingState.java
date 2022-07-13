package ru.geekbrains.patterns.state;

public class WaitingState implements State{

    public static final State  WAITING_STATE = new WaitingState();

    private WaitingState(){}

    @Override
    public void updateState(Phone phone) {
        phone.setState(EnteringNumberState.ENTERING_NUMBER_STATE);
    }

    @Override
    public String toString() {
        return "WAITING_STATE";
    }
}
