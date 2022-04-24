package ru.geekbrains.homework10;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    public MyArraySizeException(String s) {
        super("length of " + s + " dimension in array is invalid");
    }
}
