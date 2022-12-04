package com.jmmunoz.reactive.r08_flowable_and_backpressure.r04_flowable_vs_observable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Para convertir un Observable en un Flowable se usa el método toFlowable() y necesita como argumento la estrategia
// de backPressure.
//
// Para convertir un Flowable en un Observable se usa el método toObservable()
public class R02_Conversion {

    public static void main(String[] args) throws InterruptedException {

        // De Observable a Flowable
        Observable.range(1, 1000000)
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(e -> System.out.println("To Flowable: " + e + " " + Thread.currentThread().getName()));

        Thread.sleep(5000);

        // De Flowable a Observable
        Flowable.range(1, 1000000)
                .toObservable()
                .observeOn(Schedulers.io())
                .subscribe(e -> System.out.println("To Observable: " + e + " " + Thread.currentThread().getName()));

        Thread.sleep(5000);
    }
}
