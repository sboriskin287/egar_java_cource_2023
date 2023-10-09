package org.example;

import java.util.concurrent.CountDownLatch;

public class RainbowCDL implements Runnable {
    private final String print;
    private final CountDownLatch await;
    private final CountDownLatch countdown;

    public RainbowCDL(String print, CountDownLatch await, CountDownLatch countdown) {
        this.print = print;
        this.await = await;
        this.countdown = countdown;
    }

    @Override
    public void run() {
        try {
            await.await();
            System.out.print(print);
            Thread.sleep(500);
            countdown.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
