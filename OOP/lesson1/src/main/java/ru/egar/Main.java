package ru.egar;

import ru.egar.v2.Attraction;
import ru.egar.v2.Horses;
import ru.egar.v2.Train;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Attraction h = new Horses();
        Attraction t = new Train();
        var hStart = h.start();
        Thread.sleep(1000);
        var hFinish = h.finish();
        System.out.printf("Лошадки скакали %d секунд\n",
                Duration.between(hStart, hFinish).getSeconds());

        var tStart = t.start();
        Thread.sleep(1000);
        var tFinish = t.finish();
        System.out.printf("Я паровозик, который смог и я смог это за %d секунд\n",
                Duration.between(tStart, tFinish).getSeconds());

    }
}