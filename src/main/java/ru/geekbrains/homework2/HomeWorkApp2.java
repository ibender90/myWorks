package ru.geekbrains.homework2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
//        System.out.println(checkSumRange(5, 5));
//        printPositiveOrNegative(-11);
//        System.out.println(checkIsPositive(11));
//        printMeThisTimes("hello", 3);
//        System.out.println(checkIsLeapYear(2022));
    }

    public static boolean checkSumRange(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void printPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }

    public static boolean checkIsPositive(int a) {
        return a >= 0;
    }

    public static void printMeThisTimes(String text, int reps) {
        for (int i = 0; i < reps; i++) {
            System.out.println(text);
        }
    }

    public static boolean checkIsLeapYear(int year) {
        if (year % 4 == 0) {
            return year % 100 != 0 || year % 400 == 0;
        } else return false;
    }
}
