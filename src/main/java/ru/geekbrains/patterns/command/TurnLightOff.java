package ru.geekbrains.patterns.command;

public class TurnLightOff implements Command{
    private Light light;

    public TurnLightOff(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        this.light.turnOff();
    }
}
