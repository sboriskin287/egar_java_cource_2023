package org.example.customprojectreactor.subscriber;

import org.example.customprojectreactor.subscription.Subscription;

public abstract class Subscriber<T> {
    public abstract void onSubscribe(Subscription subscription);

    public abstract void onNext(T t);
    public abstract void onError(Throwable error);
    public abstract void onComplete();

}
