package ru.geekbrains.patterns.visitor;

public abstract class PersonVisitor {
    abstract void ShowTeacherInfo(Teacher teacher);
    abstract void ShowStudentInfo(Student student);
}
