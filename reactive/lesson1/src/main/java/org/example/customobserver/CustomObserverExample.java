package org.example.customobserver;

public class CustomObserverExample {

    public static void run() {
        NewsAgency na = new NewsAgency();
        var ae = new ArmchairExpert();
        na.subscribe(ae);
        na.subscribe(new Exchange());
        na.loudNew("Ура, доллар ниже сотки");
        na.loudNew("Ура, Через месяц Новый год");
        na.unsubscribe(ae);
        na.loudNew("Ура, Мандарины подешевели на 42 копейки");
    }
}
