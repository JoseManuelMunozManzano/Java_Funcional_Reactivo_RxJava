package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r02_replaying_and_caching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

// Caching es casi idéntico a Replaying
// La diferencia es que Replaying, usando el método connect() o autoConnect() devuelve un ConnectableObservable
// y Caching devuelve un Observable, así que automáticamente se suscribe cuando viene un observer.
// To-do lo demás es lo mismo que replaying.
public class R03_Caching {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .cache();

        src.subscribe(e -> System.out.println("Observer 1: " + e));

        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("Observer 2: " + e));

        Thread.sleep(3000);
    }
}
