package org.example.customobserver;

import java.util.LinkedList;
import java.util.List;

public class NewsAgency {
    private final List<Subscriber> subs = new LinkedList<>();

    public void subscribe(Subscriber subscriber) {
        subs.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subs.remove(subscriber);
    }

    public void loudNew(String news) {
        System.out.println("Внимание, у нас новая новость!!!");
        for (Subscriber sub : subs) {
            sub.onNews(news);
        }
    }

}
