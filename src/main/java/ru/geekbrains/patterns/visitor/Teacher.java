package ru.geekbrains.patterns.visitor;

public class Teacher extends Person{
    private int amountOfGroups;

    @Override
    public void visit(PersonVisitor personVisitor) {
        personVisitor.ShowTeacherInfo(this);
    }

    public int getAmountOfGroups() {
        return amountOfGroups;
    }

    public void setAmountOfGroups(int amountOfGroups) {
        this.amountOfGroups = amountOfGroups;
    }
}
