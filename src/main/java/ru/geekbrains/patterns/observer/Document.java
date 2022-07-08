package ru.geekbrains.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String body = "";
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addText(String text) {
        this.body += text;
        notifySubscribers();
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber :
                this.subscribers) {
            subscriber.notificate(this);
        }
    }

    public String getBody() {
        return body;
    }
}
