package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r05_flatmap_to_achieve_concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

// Como se indicó, para no romper el contrato del Observable, no se pueden ejecutar emisiones concurrentemente
// en un único Observer.
// Pero, qué pasa si creamos muchos Observables a partir de esas emisiones y luego ejecutamos esos Observables
// de forma paralela usando el operador flatMap, cada uno teniendo su propio thread por los que pasan los items?
//
// Usad esto cuando tenga sentido, ya que crear un Observable de cada emisión produce overhead.
public class FlatMapForConcurrency {

    public static void main(String[] args) throws InterruptedException {

        // Un único Observer se va a subscribir a este Observable
        // Se va a convertir cada emisión en un Observable (usando flatMap) y se van a procesar de forma paralela.
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .flatMap(e -> Observable.just(e)
                .subscribeOn(Schedulers.computation())
                .map(str -> compute(str)))
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }

    public static String compute(String element) throws InterruptedException {
        return element + ": Printed By: " + Thread.currentThread().getName() + " at: " + LocalTime.now();
    }
}
