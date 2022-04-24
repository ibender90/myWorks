package ru.geekbrains.homework10;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(int i, int j) {
        super("Incorect data found at [" + i + "][" + j + "]");
    }

}
