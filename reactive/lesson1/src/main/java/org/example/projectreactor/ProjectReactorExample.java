package org.example.projectreactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class ProjectReactorExample {

    public static void start() {
        Integer[] arr = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        Flux
                .fromArray(arr)
                .filter(i -> i % 2 != 0)
                .map(i -> "str" + i)
                .subscribeOn(Schedulers.parallel())
                .delayElements(Duration.ofMillis(1000))
                .subscribe(new Subscriber<>() {
                    private Subscription s;
                    private int count;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        s = subscription;
                        subscription.request(2);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                        if (++count % 2 == 0) {
                            System.out.println("Запрашиваю следующие два");
                            this.s.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println(throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("That's all");
                    }
                });
    }
}
