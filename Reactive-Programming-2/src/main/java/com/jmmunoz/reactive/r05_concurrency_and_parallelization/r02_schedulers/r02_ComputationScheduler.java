package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r02_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class r02_ComputationScheduler {

    public static void main(String[] args) throws InterruptedException {
        // Con Schedulers.computation() tenemos una nueva fuente.
        // Cualquier Observer de esta fuente obtendrá un thread de este computation pool.
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation());

        // Nos subscribimos
        // Tengo 8 cores, así que asigna 8 cores y reutiliza si hace falta
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());

        Thread.sleep(5000);
    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
