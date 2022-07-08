package ru.geekbrains.patterns.decorator;

public class Lights extends ChristmasTreeDecorator{

    public Lights(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    public String decorate(){
        return super.decorate() + decorateWithLights();
    }

    private String decorateWithLights() {
        return " with colorful lights";
    }

}
