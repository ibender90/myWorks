package ru.geekbrains.patterns.command;

public class TurnLightOn implements Command{
    private Light light;

    public TurnLightOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOn();
    }
}
