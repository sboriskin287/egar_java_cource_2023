package org.example.customprojectreactor.publisher;

import org.example.customprojectreactor.publisher.impl.ArrayPublisher;
import org.example.customprojectreactor.publisher.impl.MapPublisher;
import org.example.customprojectreactor.subscriber.Subscriber;

import java.util.function.Function;

public abstract class Publisher<T> {

    public abstract void subscribe(Subscriber<T> subscriber);

    public static <A> Publisher<A> fromArray(A... arr) {
        return new ArrayPublisher<>(arr);
    }

    public <V> Publisher<V> map(Function<T, V> mapper) {
        return new MapPublisher<>(this, mapper);
    }
}
