package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r02_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class r05_SingleScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.single());

        // Nos subscribimos
        // sensitiveTask() debe llamarse de forma síncrona porque no es Thread Safe.
        // Por eso usamos single()
        // Solo se usa un Thread
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());

        Thread.sleep(5000);
    }

    // Imaginemos que el código que hay aquí no es Thread Safe
    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
