package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class RainbowConsumerBQ implements Runnable {
    private final BlockingQueue<String> bq;

    public RainbowConsumerBQ(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            String print;
            while (!(print = bq.take()).equals("Rainbow")) {
                System.out.print(print);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
