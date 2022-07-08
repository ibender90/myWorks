package ru.geekbrains.patterns.visitor;

import java.util.LinkedList;
import java.util.List;

public class School {
    private List<Person> people = new LinkedList<>();

    public void add(Person person) {
        people.add(person);
    }

    public void accept(PersonVisitor personVisitor) {
        for (Person person : people) {
            person.visit(personVisitor);
        }
    }
}
