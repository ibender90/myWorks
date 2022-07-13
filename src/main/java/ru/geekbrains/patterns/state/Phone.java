package ru.geekbrains.patterns.state;

public class Phone {
    private State state = WaitingState.WAITING_STATE;

    public void switchState(){
        state.updateState(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
