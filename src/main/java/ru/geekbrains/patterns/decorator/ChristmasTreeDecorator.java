package ru.geekbrains.patterns.decorator;

public abstract class ChristmasTreeDecorator implements ChristmasTree{
    private ChristmasTree christmasTree;

    public ChristmasTreeDecorator(ChristmasTree christmasTree) {
        this.christmasTree = christmasTree;
    }

    @Override
    public String decorate(){
        return christmasTree.decorate();
    }
}
