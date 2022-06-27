package ru.geekbrains.patterns;

public class Singleton {
    private static Singleton instance = null;

    public Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
