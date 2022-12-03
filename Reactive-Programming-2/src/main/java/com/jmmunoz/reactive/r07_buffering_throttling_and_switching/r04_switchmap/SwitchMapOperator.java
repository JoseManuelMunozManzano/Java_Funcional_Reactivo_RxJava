package com.jmmunoz.reactive.r07_buffering_throttling_and_switching.r04_switchmap;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// Similar a flatMap() en que aplana el observable, pero diferente en que solo se subscribe al observable que emite
// el último item y desecha los previos. De esta forma nos permite cancelar el Observable que emite y cambiar a uno
// nuevo, siempre con el objetivo de evitar procesamiento redundante.
//
// Es muy útil para evitar que el sistema reciba demasiadas peticiones de conexión.
public class SwitchMapOperator {

    public static void main(String[] args) throws InterruptedException {
        // Hay un delay entre dos emisiones consecutivas de 1 sg.
        // Solo emite items que obtiene entre 2 segundos de duración y luego repite el proceso.
        // Por tanto, emitirá cada nuevo Observable en dos segundos y desechará el anterior sin importar si se ha
        // procesado o no.
        Observable<String> source = Observable.just("Adri", "José", "Tania", "Ferney", "Jaimito")
                .concatMap(s -> Observable.just(s)
                        .delay(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS
                        )
                );

        Observable.interval(2, TimeUnit.SECONDS)
                .switchMap(s -> source.doOnDispose(() -> {
                    System.out.println("Disposing and starting again!");
                }))
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
