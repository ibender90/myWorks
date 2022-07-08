package ru.geekbrains.patterns.observer;

public class JournalApp {
    public static void main(String[] args) {
        Document newsPaper = new Document();

        Person author = new Person(1, "Peter Parker");
        Person reader = new Person(2, "Adam Louis");
        Person reviewer = new Person(3, "Jack Nickelson");

        newsPaper.addSubscriber(reader);
        newsPaper.addSubscriber(reviewer);

        newsPaper.addText("Murder in Bikini Bottom!!!");
    }
}
