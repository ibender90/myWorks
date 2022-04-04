package ru.geekbrains.homework5;

public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Олег Олегович Олежко", "Слесарь",
                "o.o@mail.ru", "+123 321", 10_000, 56);
        employees[1] = new Employee("Роман Романович Романенко", "Сварщик",
                "r.r@mail.ru", "+123 322", 12_000, 52);
        employees[2] = new Employee("Татьяна Олеговна Восьмиглазова", "Бухчалтер",
                "t.v@mail.ru", "+123 323", 7_000, 33);
        employees[3] = new Employee("Виктор Викторович Катамаранов", "Эксковаторщик",
                "v.k@mail.ru", "+123 324", 15_000, 42);
        employees[4] = new Employee("Ричард Ричардович Сапогов", "Директор",
                "r.r@mail.ru", "+123 325", 20_000, 40);

        for (Employee oldPerson:employees) {
            if(oldPerson.getAge() > 40){
                oldPerson.printInfo();
            }
        }
    }
}
