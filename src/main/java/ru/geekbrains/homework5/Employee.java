package ru.geekbrains.homework5;

public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phoneNumber; // номер может содержать знак + и дефисы поэтому string
    private int salary;
    private int age;

    public Employee(String FIO, String position, String email, String phoneNumber, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() { //немного изменил стандартный toString сгенерированный через Idea
        System.out.println( "Employee{" +
                "FIO='" + FIO + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}');
    }

    public int getAge() { // геттер для доступа к полю age
        return age;
    }
}
