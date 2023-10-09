package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Long> {
    static Set<String> threads = new HashSet<>();
    private final Integer[] arr;
    private static final int THRESHOLD = 10;

    public CustomRecursiveTask(Integer[] arr) {
        this.arr = arr;
    }

    @Override
    protected Long compute() {
        if (arr.length > THRESHOLD) {
            return diveInto();
        } else {
            return processing();
        }
    }

    private Long diveInto() {
        var t1 = new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2));
        var t2 = new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        t1.fork();
        t2.fork();
        return t1.join() + t2.join();
    }

    private Long processing() {
        try {
            threads.add(Thread.currentThread().getName());
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(arr)
                .filter(n -> n > 7)
                .count();
    }
}
