package org.example.customprojectreactor.subscriber.impl;

import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.Subscription;

import java.util.function.Function;

public class MapSubscriber<K, V> extends Subscriber<K> {
    private final Subscriber<V> actual;
    private final Function<K, V> mapper;

    public MapSubscriber(Subscriber<V> actual, Function<K, V> mapper) {
        this.actual = actual;
        this.mapper = mapper;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        actual.onSubscribe(subscription);
    }

    @Override
    public void onNext(K v) {
        var mapNext = mapper.apply(v);
        actual.onNext(mapNext);
    }

    @Override
    public void onError(Throwable error) {
        actual.onError(error);
    }

    @Override
    public void onComplete() {
        actual.onComplete();
    }
}
