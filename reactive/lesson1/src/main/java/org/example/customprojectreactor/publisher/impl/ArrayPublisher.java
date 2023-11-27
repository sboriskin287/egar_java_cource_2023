package org.example.customprojectreactor.publisher.impl;

import org.example.customprojectreactor.publisher.Publisher;
import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.impl.ArraySubscription;

public class ArrayPublisher<T> extends Publisher<T> {

    private final T[] arr;

    public ArrayPublisher(T[] arr) {
        this.arr = arr;
    }

    @Override
    public void subscribe(Subscriber<T> subscriber) {
        subscriber.onSubscribe(new ArraySubscription<>(subscriber, arr));
    }
}
