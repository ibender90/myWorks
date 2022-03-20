package ru.geekbrains.homework1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printTreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printTreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign(){
        int a = 5, b = 7;
        int sum = a+b;
        if(sum >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(){
        int value = 13;
        if (value <= 0){
            System.out.println("Красный");
        } else if(value > 0 && value <= 100){
            System.out.println("Жёлтый");
        } else if(value > 100) {
            System.out.println("Зелёный");
        }
    }
    public static void compareNumbers(){
        int a = 1;
        int b = 2;
        if(a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
