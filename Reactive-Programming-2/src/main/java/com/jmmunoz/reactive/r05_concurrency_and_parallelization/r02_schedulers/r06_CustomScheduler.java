package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r02_schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class r06_CustomScheduler {

    public static void main(String[] args) throws InterruptedException {
        // Creamos nuestro executorService con un pool de 20 threads
        ExecutorService executor = Executors.newFixedThreadPool(20);

        // A partir de ese Executor creamos nuestro scheduler
        Scheduler scheduler = Schedulers.from(executor);

        // Usamos el scheduler creado
        // Usamos el doFinally() para ejecutar el método shutdown() en el ExecutorService tras
        // completar todas las tareas.
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown);

        // Nos subscribimos
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

        // Como hemos creado el scheduler desde un Executor no hace falta poner el sleep para mantener viva la app.
        // Thread.sleep(5000);
    }

    // Imaginemos que el código que hay aquí no es Thread Safe
    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By: " + Thread.currentThread().getName());
    }
}
