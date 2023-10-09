package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RainbowCB implements Runnable {
    private final String print;
    private final CyclicBarrier currCB;
    private final CyclicBarrier nextCB;

    private CyclicBarrier finalCB;

    public RainbowCB(String print, CyclicBarrier currCB, CyclicBarrier nextCB) {
        this.print = print;
        this.currCB = currCB;
        this.nextCB = nextCB;
    }

    public RainbowCB(String print, CyclicBarrier currCB, CyclicBarrier nextCB, CyclicBarrier finalCB) {
        this.print = print;
        this.currCB = currCB;
        this.nextCB = nextCB;
        this.finalCB = finalCB;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i +=1) {
            try {
                currCB.await();
                System.out.print(print);
                Thread.sleep(500);
                if (finalCB == null || i != 4) nextCB.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
        if (finalCB != null) {
            try {
                finalCB.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
