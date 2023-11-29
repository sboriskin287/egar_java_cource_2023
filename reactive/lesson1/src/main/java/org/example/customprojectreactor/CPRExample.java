package org.example.customprojectreactor;

import org.example.customprojectreactor.publisher.Publisher;
import org.example.customprojectreactor.subscriber.Subscriber;
import org.example.customprojectreactor.subscription.Subscription;

public class CPRExample {
    public static void start() {
        Publisher
                .fromArray(0,1,2,3,4,5,6,7,8,9)
                .filter(i -> i % 2 == 1)
                .map(i -> "str" + i)
                .parallel(10)
                .subscribe(new Subscriber<>() {

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(String integer) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println(error);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Custom that's all");
                    }
                });
    }
}
