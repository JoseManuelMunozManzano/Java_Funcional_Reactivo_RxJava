package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r02_replaying_and_caching;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

// En el método replay() se puede pasar la cantidad de emisiones a cachear (siempre serán las x últimas emisiones)
// O también se puede pasar un TimeUnit y hará el replay de las últimas emisiones que hubo en ese TimeUnit.
// O también se puede limitar tanto la cantidad como el tiempo. En este caso, solo la cantidad de emisiones
// indicada de las últimas emisiones realizadas quedan en el buffer dentro de este tiempo periodo de tiempo.
public class R02_ReplayingBuffer {
    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2)
                // Ejemplo pasando un TimeUnit
                //.replay(1, TimeUnit.SECONDS)
                // Ejemplo pasando cantidad y TimeUnit. Aunque haya puesto 3, como es 1 sg solo envía al segundo
                // subscriber a partir de la emisión 4
                //.replay(3, 1, TimeUnit.SECONDS)
                .autoConnect();

        src.subscribe(e -> System.out.println("Observer 1: " + e));

        Thread.sleep(5000);

        // Este segundo subscriber llega tarde, y esta vez solo se hace el replaying de las dos últimas emisiones,
        // ya que en replay se ha indicado un buffer (o cache) de 2.
        src.subscribe(e -> System.out.println("Observer 2: " + e));

        Thread.sleep(3000);
    }
}
