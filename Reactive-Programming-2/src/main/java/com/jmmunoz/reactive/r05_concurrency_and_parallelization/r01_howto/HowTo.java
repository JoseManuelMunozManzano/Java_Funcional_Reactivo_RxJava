package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r01_howto;

import io.reactivex.rxjava3.core.Observable;

// La ventaja principal de usar programación reactiva consiste en hacer el código asíncrono.
// Los observables tienen un contrato: Las emisiones se pasan secuencialmente y uno a la vez.
// Cómo puede hacerse para que la tarea se ejecute asincrónicamente en un programa con RxJava?
public class HowTo {

    public static void main(String[] args) {

        // Ejemplo típico secuencial
        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext("rxJava");
                }
        );

        source.subscribe(e -> System.out.println("Source0. Observer 1: " + e
                + " Thread is: " + Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Source0. Observer 2: " + e
                + " Thread is: " + Thread.currentThread().getName()));

        // Para que la tarea sea asíncrona los métodos onNext() se llaman dentro de un Runnable, se crea un Thread y se
        // lanza el método start()
        // No se rompe el contrato porque no se pasan las emisiones de forma asíncrona. Lo que se hace es que un
        // nuevo thread envía las emisiones al Observer de manera síncrona.
        // El comportamiento asíncrono se consigue procesando múltiples subscripciones paralelamente en diferentes
        // threads en vez de procesar las emisiones en el mismo Observer de manera concurrente.
        Observable<String> source2 = Observable.create(
                e -> {
                    new Thread( () -> {
                        e.onNext("Hello");
                        e.onNext("rxJava");
                    }
                    ).start();
                }
        );

        source2.subscribe(e -> System.out.println("Source1. Observer 1: " + e
                + " Thread is: " + Thread.currentThread().getName()));
        source2.subscribe(e -> System.out.println("Source1. Observer 2: " + e
                + " Thread is: " + Thread.currentThread().getName()));

        // No es necesario crear Threads en los Observables para conseguir concurrencia.
        // RxJava ya tiene implementados diferentes schedulers que podemos usar para conseguir el comportamiento
        // asíncrono.
    }
}
