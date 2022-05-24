package ru.geekbrains.homework_13;
/*
Разница в скорости на m1 чипе получилась 850ms  и  1 ms
 */

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class Multithreading {
    static final int size = 100;//000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        simpleArrayProcessing();
        advancedArrayProcessing();
    }

    private static void simpleArrayProcessing() {
        float[] arr = makeArr();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime);
    }

    private static void advancedArrayProcessing() {
        float[] arr = makeArr();

        long startTime = System.currentTimeMillis();

        float[] firstHalf = new float[h];
        float[] secondHalf = new float[h];


        Thread processFirstHalf = new Thread(new Runnable() {
            @Override
            public void run() {
                arraycopy(arr, 0, firstHalf, 0, h);
                for (int i = 0; i < h; i++) {
                    firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println(Arrays.toString(firstHalf));
            }
        });

        Thread processSecondHalf = new Thread(new Runnable() {
            @Override
            public void run() {
                arraycopy(arr, h, secondHalf, 0, h);
                for (int i = 0; i < h; i++) {
                    secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println(Arrays.toString(secondHalf));
            }


        });

        processFirstHalf.start();
        processSecondHalf.start();

        System.arraycopy(firstHalf, 0, arr, 0, h);
        System.arraycopy(secondHalf, 0, arr, h, h);


        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime);

        System.out.println(Arrays.toString(arr));
    }

    private static float[] makeArr() {
        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}
