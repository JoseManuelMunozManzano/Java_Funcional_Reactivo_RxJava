package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r02_replaying_and_caching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

// Vamos a ver como hacer el replay de emisiones desde el comienzo para un Observer que ha llegado tarde.
// El método es source.replay() y lo vamos a ver en un ejemplo con un Connectable Observable, que no espera a ninguna
// subscripción y que comienza a emitir cuando se llama a su método connet()
public class R01_Replaying {

    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();

        src.subscribe(e -> System.out.println("Observer 1: " + e));

        Thread.sleep(5000);

        // Este segundo subscriber llega tarde, pero igualmente recibe todas las emisiones
        src.subscribe(e -> System.out.println("Observer 2: " + e));

        Thread.sleep(3000);
    }
}
