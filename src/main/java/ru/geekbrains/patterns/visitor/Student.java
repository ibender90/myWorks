package ru.geekbrains.patterns.visitor;

public class Student extends Person{
    private int groupID;

    @Override
    public void visit(PersonVisitor personVisitor) {
        personVisitor.ShowStudentInfo(this);
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
