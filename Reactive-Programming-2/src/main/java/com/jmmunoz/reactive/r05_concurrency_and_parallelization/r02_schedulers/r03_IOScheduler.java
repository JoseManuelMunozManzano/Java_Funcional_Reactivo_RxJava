package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r02_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class r03_IOScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.io());

        // Nos subscribimos
        // Aunque tengo 8 cores, asigna 10
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());
        src.subscribe(e -> ioOperation());

        Thread.sleep(5000);
    }

    public static void ioOperation() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
