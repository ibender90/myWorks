package ru.geekbrains.patterns.decorator;

public class Toys extends ChristmasTreeDecorator{
    public Toys(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    public String decorate(){
        return super.decorate() + decorateWithToys();
    }

    private String decorateWithToys() {
        return " with different toys";
    }
}
