package ru.geekbrains.patterns.visitor;

public class TextPersonVisitor extends PersonVisitor
{
    @Override
    void ShowTeacherInfo(Teacher teacher) {
        String info = "Name= " + teacher.name + ", surname= " + teacher.surname + ", groups= " + teacher.getAmountOfGroups();
        System.out.println(info);
    }

    @Override
    void ShowStudentInfo(Student student) {
        String info = "Name= " + student.name + ", surname= " + student.surname + ", groupID= " + student.getGroupID();
        System.out.println(info);
    }
}
