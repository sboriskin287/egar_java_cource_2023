package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RainbowProducerBQ implements Runnable {
    private final BlockingQueue<String> bq;
    private final String print;
    private final int consumerNumberPerThread;

    public RainbowProducerBQ(BlockingQueue<String> bq, String print, int consumerNumberPerThread) {
        this.bq = bq;
        this.print = print;
        this.consumerNumberPerThread = consumerNumberPerThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i += 1) {
                bq.put(print);
            }
            for (int i = 0; i < consumerNumberPerThread; i += 1) {
                bq.put("Rainbow");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
