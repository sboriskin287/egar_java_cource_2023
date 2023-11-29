package org.example.customprojectreactor.publisher;

import org.example.customprojectreactor.publisher.impl.ArrayPublisher;
import org.example.customprojectreactor.publisher.impl.FilterPublisher;
import org.example.customprojectreactor.publisher.impl.MapPublisher;
import org.example.customprojectreactor.publisher.impl.ParallelPublisher;
import org.example.customprojectreactor.subscriber.Subscriber;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Publisher<T> {

    public abstract void subscribe(Subscriber<T> subscriber);

    @SafeVarargs
    public static <A> Publisher<A> fromArray(A... arr) {
        return new ArrayPublisher<>(arr);
    }

    public <V> Publisher<V> map(Function<T, V> mapper) {
        return new MapPublisher<>(this, mapper);
    }

    public Publisher<T> filter(Predicate<T> condition) {
        return new FilterPublisher<>(this, condition);
    }

    public Publisher<T> parallel(int poolSize) {
        return new ParallelPublisher<>(this, poolSize);
    }
}
