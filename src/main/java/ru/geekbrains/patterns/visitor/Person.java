package ru.geekbrains.patterns.visitor;

public abstract class Person {
    public String name;
    public String surname;
    public abstract void visit(PersonVisitor personVisitor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
