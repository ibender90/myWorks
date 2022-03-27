package ru.geekbrains.homework3;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
//        int [] signal = {1,0,1};
//        System.out.println(Arrays.toString(invertSignal(signal))); //проверка первого задания
//        System.out.println(Arrays.toString(giveMeArrayOfHundredNumbers())); //проверка второго задания

        int[] arrayFromTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        System.out.println(Arrays.toString(editArray(arrayFromTask))); //проверка третьего задания
//
//        drawMeX(9); //проверка четвёртого задания
//        printMinAndMax(arrayFromTask); //проверка шестого задания

//        int[] arr1 = {1, 1};
//        int[] arr2 = {1, 2, 3};
//        int[] arr3 = {3, 2, 1};
//        int[] arr4 = {1, 1, 1, 2, 1};
//        int[] arr5 = {2, 2, 2, 1, 2, 2, 10, 1};
//        System.out.println(checkBalance(arr5)); //проверка седьмого задания

    }

    public static int[] invertSignal(int[] input) { //первое задание
        for (int i = 0; i < input.length; i++) {
            input[i] = Math.abs(input[i] - 1);
        }
        return input;
    }

    public static int[] giveMeArrayOfHundredNumbers() { //второе задание
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] editArray(int[] inputArr) { //третье задание (не смог придумать правильное название методу)
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] < 6) {
                inputArr[i] *= 2;
            }
        }
        return inputArr;
    }

    public static void drawMeX(int size) { //четвёртое задание (можно указать желаемый размер квадрата)
        int[][] array = new int[size][size];
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (x == y || (x + y == size - 1)) {
                    array[y][x] = 1;
                }
                System.out.print(array[y][x] + "\t");
            }
            System.out.println();
        }
    }

    public static void printMinAndMax(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.printf("Minimum found: %d\nMaximum found: %d", min, max);
    }

    public static boolean checkBalance(int[] arr) {
        if(arr.length < 2){
            return false; // массив из одного элемента не подходит по условиям задачи
        }
        int left = arr[0];
        int rightPointer = arr.length - 1;
        int right = arr[rightPointer];

        for (int leftPointer = 1; leftPointer < rightPointer; leftPointer++) {
            if (left == right) {
                left += arr[leftPointer + 1];
                continue;
            }
            if (left > right) {
                rightPointer--;
                right += arr[rightPointer];
            }
            if (left < right) {
                left += arr[leftPointer];
            }
        }
        return right == left;
    }
}
