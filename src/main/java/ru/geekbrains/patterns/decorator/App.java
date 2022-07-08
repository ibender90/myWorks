package ru.geekbrains.patterns.decorator;

public class App {
    public static void main(String[] args) {
        ChristmasTree tree1 = new Lights(new Toys(new ChristmasTreeImplementation()));
        //Christmas tree with different toys with colorful lights
        System.out.println(tree1.decorate());

        ChristmasTree tree2 = new ChristmasTreeImplementation();
        //Christmas tree
        System.out.println(tree2.decorate());

        ChristmasTree tree3 = new Toys(new ChristmasTreeImplementation());
        //Christmas tree with different toys
        System.out.println(tree3.decorate());
    }
}
