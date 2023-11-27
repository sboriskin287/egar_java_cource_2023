package org.example.customobserver;

public class Exchange implements Subscriber {
    @Override
    public void onNews(String news) {
        System.out.println("Курс акций изменился из-за: " + news);
    }
}
