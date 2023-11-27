package org.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxJavaExample {

    public static void start() {
        Integer[] arr = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        var o = Observable
                .fromArray(arr)
                .filter(i -> i % 2 == 0)
                .map(i -> i + "_str");
        o
                //.delay(100, TimeUnit.MILLISECONDS)
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.err.println(e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("It's end");
                    }
                });
        o.subscribe(i -> System.out.println("Другой подписчик " + i));
    }
}
