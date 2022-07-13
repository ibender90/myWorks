package ru.geekbrains.patterns.state;

public class PhoneApp {
    public static void main(String[] args) {
        Phone phone = new Phone();

        for (int i = 0; i < 10; i++) {
            System.out.println(phone.getState());
            phone.switchState();
        }
    }
}
