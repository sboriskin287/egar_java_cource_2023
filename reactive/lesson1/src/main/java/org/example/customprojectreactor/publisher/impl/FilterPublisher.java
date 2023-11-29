package org.example.customprojectreactor.publisher.impl;

import org.example.customprojectreactor.publisher.Publisher;
import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscriber.impl.FilterSubscriber;

import java.util.function.Predicate;

public class FilterPublisher<T> extends Publisher<T> {
    private final Publisher<T> upstream;
    private final Predicate<T> condition;

    public FilterPublisher(Publisher<T> upstream,
                           Predicate<T> condition) {
        this.upstream = upstream;
        this.condition = condition;
    }

    @Override
    public void subscribe(Subscriber<T> subscriber) {
        upstream.subscribe(new FilterSubscriber<>(subscriber, condition));
    }
}
