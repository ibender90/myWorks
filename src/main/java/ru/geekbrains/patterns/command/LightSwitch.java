package ru.geekbrains.patterns.command;

public class LightSwitch {
    public static void main(String[] args) {
        Light lamp = new Light();

        TurnLightOn lightOn = new TurnLightOn(lamp);
        TurnLightOff lightOff = new TurnLightOff(lamp);

        lightOn.execute();
        lightOff.execute();
        //можно создать класс который будет управлять этими командами как угодно
    }
}
