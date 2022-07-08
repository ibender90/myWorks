package ru.geekbrains.patterns.visitor;

public class HTMLPersonVisitor extends PersonVisitor{
    @Override
    void ShowTeacherInfo(Teacher teacher) {
        String info = "Name= <h1>" + teacher.name +
                        "</h1>, surname= <h1>" + teacher.surname +
                        "</h1>, groups= <h2>" + teacher.getAmountOfGroups() + "</h2>";
        System.out.println(info);
    }

    @Override
    void ShowStudentInfo(Student student) {
        String info = "Name= <h1>" + student.name +
                        "</h1>, surname= <h1>" + student.surname +
                        "</h1>, groups= <h2>" + student.getGroupID() + "</h2>";
        System.out.println(info);
    }
}
