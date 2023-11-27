package org.example.customprojectreactor.publisher.impl;

import org.example.customprojectreactor.publisher.Publisher;
import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscriber.impl.MapSubscriber;

import java.util.function.Function;

public class MapPublisher<K, V> extends Publisher<V> {
    private final Publisher<K> upstream;
    private final Function<K, V> mapper;

    public MapPublisher(Publisher<K> upstream, Function<K, V> mapper) {
        this.upstream = upstream;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<V> subscriber) {
        upstream.subscribe(new MapSubscriber<>(subscriber, mapper));
    }
}
