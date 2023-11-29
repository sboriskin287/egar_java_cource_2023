package org.example.customprojectreactor.subscriber.impl;

import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.Subscription;

import java.util.function.Predicate;

public class FilterSubscriber<T> extends Subscriber<T> {
    private final Subscriber<T> actual;
    private final Predicate<T> condition;

    public FilterSubscriber(Subscriber<T> actual, Predicate<T> condition) {
        this.actual = actual;
        this.condition = condition;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        actual.onSubscribe(subscription);
    }

    @Override
    public void onNext(T t) {
        if (condition.test(t)) {
            actual.onNext(t);
        }
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
