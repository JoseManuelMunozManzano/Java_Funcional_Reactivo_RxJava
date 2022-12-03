package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r02_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class r04_NewThreadScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.newThread());

        // Nos subscribimos
        // Un thread por Observer --> 10 threads que se terminan tras completar su tarea
        // El thread 1 que se genera aquí se termina tras acabar el sleep
        src.subscribe(e -> task());

        Thread.sleep(6000);

        // Y aquí ya no se usa ese Thread (el 1), sino que se generan otros números de Thread, el 2, 3...
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());

        Thread.sleep(5000);
    }

    public static void task() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
