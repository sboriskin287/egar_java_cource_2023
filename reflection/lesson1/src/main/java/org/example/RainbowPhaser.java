package org.example;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class RainbowPhaser implements Runnable{
    private final String print;
    private final Phaser ph;
    private final int phase;

    public RainbowPhaser(String print, Phaser ph, int phase) {
        this.print = print;
        this.ph = ph;
        this.phase = phase;
        ph.register();
    }

    @Override
    public void run() {
        try {
            int step = 0;
            while (ph.arriveAndAwaitAdvance() != phase) {
                System.out.println(step++);
            }
            System.out.println(print);
            TimeUnit.MILLISECONDS.sleep(500);
            ph.arriveAndDeregister();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
