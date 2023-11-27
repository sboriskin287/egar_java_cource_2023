package org.example.customprojectreactor.subscriber.impl;

import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.Subscription;

import java.util.function.Function;

public class MapSubscriber<K, V> extends Subscriber<K> {
    private final Subscriber<V> upstream;
    private final Function<K, V> mapper;

    public MapSubscriber(Subscriber<V> upstream, Function<K, V> mapper) {
        this.upstream = upstream;
        this.mapper = mapper;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        upstream.onSubscribe(subscription);
    }

    @Override
    public void onNext(K v) {
        var mapNext = mapper.apply(v);
        upstream.onNext(mapNext);
    }

    @Override
    public void onError(Throwable error) {
        upstream.onError(error);
    }

    @Override
    public void onComplete() {
        upstream.onComplete();
    }
}
