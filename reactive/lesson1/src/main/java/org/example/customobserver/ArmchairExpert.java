package org.example.customobserver;

public class ArmchairExpert implements Subscriber {
    @Override
    public void onNews(String news) {
        System.out.println("Обсуждаем с мужиками последние новости: " + news);
    }
}
