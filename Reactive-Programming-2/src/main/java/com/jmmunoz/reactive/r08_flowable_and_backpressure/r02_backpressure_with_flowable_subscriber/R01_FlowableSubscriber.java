package com.jmmunoz.reactive.r08_flowable_and_backpressure.r02_backpressure_with_flowable_subscriber;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Al igual que tenemos Observables que emiten items a un Observer, también tenemos Flowables y Subscriber.
// Flowable emite y Subscriber escucha esas emisiones.
// Flowable es el reemplazo de Observable cuando necesitamos backPressure.
// Lo que hace Flowable (el Producer) es emitir una cantidad limitada de items que son luego consumidas por el Consumer.
// Una vez consumidas el Producer vuelve a emitir esa cantidad de items que vuelven a ser consumidos.
// A este comportamiento se le llama backPressure.
public class R01_FlowableSubscriber {

    public static void main(String[] args) {
        // Las primeras 128 emisiones salen de Flowable.range() y son consumidas por el Subscriber.
        // Luego se emiten 97 items que vuelven a ser consumidas, luego otras 96...
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is: " + e + " - " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                // La diferencia con Observable es que subscribe, en este flujo con Flowable, no puede usar
                // onDisposable()
                // La lambda que se le pasa a subscribe es un Subscriber.
                // Es decir, que subscribe en un objeto flowable retorna un objeto Subscription y se le puede hacer
                // dispose llamando al método cancel(), que sustituye a onDisposable()
                // Además, el objeto Subscription es muy útil porque no solo puede usarse para cancelar la subscripción,
                // también puede comunicar corriente arriba cuantos items se piden de una vez, usando el método
                // request(), es decir, se puede controlar el número de emisiones explícitamente.
                .subscribe(e -> {
                    sleep(100);
                    System.out.println("Consumed item is: " + e + " - " + Thread.currentThread().getName());
                });
        sleep(100000000);
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
