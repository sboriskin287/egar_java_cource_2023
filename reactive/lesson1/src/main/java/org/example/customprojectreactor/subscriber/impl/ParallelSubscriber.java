package org.example.customprojectreactor.subscriber.impl;

import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.Subscription;

import java.util.concurrent.ExecutorService;

public class ParallelSubscriber<T> extends Subscriber<T> {
    private final Subscriber<T> actual;
    private final ExecutorService pool;

    public ParallelSubscriber(Subscriber<T> actual,
                              ExecutorService pool) {
        this.actual = actual;
        this.pool = pool;
    }


    @Override
    public void onSubscribe(Subscription subscription) {
        actual.onSubscribe(subscription);
    }

    @Override
    public void onNext(T t) {
        pool.submit(() -> actual.onNext(t));
    }

    @Override
    public void onError(Throwable error) {
        actual.onError(error);
    }

    @Override
    public void onComplete() {
        actual.onComplete();
        pool.shutdown();
    }
}
