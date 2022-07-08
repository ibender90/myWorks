package ru.geekbrains.patterns.visitor;

public class SchoolApp {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Vasja");
        student.setSurname("Pupkin");
        student.setGroupID(113);

        Teacher teacher = new Teacher();
        teacher.setName("Gennadij");
        teacher.setSurname("Medkov");
        teacher.setAmountOfGroups(0);

        School gymnasium = new School();

        gymnasium.add(student);
        gymnasium.add(teacher);

        HTMLPersonVisitor htmlPersonVisitor = new HTMLPersonVisitor();
        TextPersonVisitor textPersonVisitor= new TextPersonVisitor();

        gymnasium.accept(htmlPersonVisitor);
        gymnasium.accept(textPersonVisitor);
    }
}
