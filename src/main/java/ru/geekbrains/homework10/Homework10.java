package ru.geekbrains.homework10;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Homework10 {
    public static void main(String[] args) {
        String[][] testArray = new String[4][4]; //поменять размер чтобы вызвать исключение
        {
            for (int i = 0; i < testArray.length; i++) {
                Arrays.fill(testArray[i], "2");
            }
//            testArray[0][1] = "hello"; //раскомментировать чтобы получить ошибку
        }


        try {
            scanArray(testArray);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void scanArray(String[][] inputArray) throws MyArrayDataException, MyArraySizeException{
        if (inputArray.length != 4) {
            throw new MyArraySizeException("second");
        }

        for (int i = 0; i < 4; i++) {
            if (inputArray[i].length != 4) {
                throw new MyArraySizeException("first");
            }
        }

        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }

}
