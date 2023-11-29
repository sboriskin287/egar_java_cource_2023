package org.example.customprojectreactor.publisher.impl;

import org.example.customprojectreactor.publisher.Publisher;
import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscriber.impl.ParallelSubscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelPublisher<T> extends Publisher<T> {
    private final Publisher<T> upstream;
    private final int poolSize;

    public ParallelPublisher(Publisher<T> upstream, int poolSize) {
        this.upstream = upstream;
        this.poolSize = poolSize;
    }

    @Override
    public void subscribe(Subscriber<T> subscriber) {
        var pool = Executors.newFixedThreadPool(poolSize);
        upstream.subscribe(new ParallelSubscriber<>(subscriber, pool));
    }
}
