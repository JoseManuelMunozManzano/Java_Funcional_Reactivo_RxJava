package com.jmmunoz.reactive.r02_observable_and_observers.r05_connectable_observables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

// Connectable Observables son observables que convierten Cold Observables en Hot Observables.
// Un simil de Hot Observable sería una radio. Un oyente podría escuchar una canción y otro oyente que
// conectara esa emisora más tarde a lo mejor se la pierde.
public class ConnectableObservables {

    public static void main(String[] args) throws InterruptedException {

        // Este Observable es un Cold Observable
        //Observable.interval(1, TimeUnit.SECONDS);
        // Convirtiendo a Hot Observable con el método publish() Este método devuelve un Connectable Observable.
        ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

        // Para comenzar este Connectable Observable necesitamos invocar el método connect() para disparar las
        // emisiones
        source.connect();

        // Subscribimos un Observer a source
        source.subscribe(System.out::println);

        // Digamos que pasados 5 segundos otro Observer se subscribe a source.
        // Este segundo subscriber empieza a recibir los datos emitidos a partir del valor 5
        Thread.sleep(5000);
        source.subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
