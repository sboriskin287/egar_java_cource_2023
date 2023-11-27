package org.example.customprojectreactor.subscription.impl;

import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.Subscription;

public class ArraySubscription<T> extends Subscription {
    private final Subscriber<T> subscriber;
    private final T[] arr;

    public ArraySubscription(Subscriber<T> s, T[] arr) {
        this.subscriber = s;
        this.arr = arr;
    }

    @Override
    public void request(Long workload) {
        for (int i = 0; i < arr.length && i < workload; i++) {
            try {
                subscriber.onNext(arr[i]);
            } catch (Throwable error) {
                subscriber.onError(error);
            }
        }
    }
}
