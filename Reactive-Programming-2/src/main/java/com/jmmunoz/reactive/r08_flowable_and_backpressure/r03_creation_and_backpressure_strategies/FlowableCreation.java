package com.jmmunoz.reactive.r08_flowable_and_backpressure.r03_creation_and_backpressure_strategies;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Hay una diferencia crítica entre Observable.create() y Flowable.create().
// En Flowable.create() tenemos que indicar, como segundo argumento, una estrategia de backPressure.
// 1. BUFFER
//      Encola emisiones en una cola ilimitada. Cuando el Consumer la consume la cola se vacía.
//      Puede dar lugar a problemas de falta de memoria pero nos aseguramos que tenemos todos los datos emitidos.
//  2. DROP
//      Si la bajada de datos no se puede mantener, las emisiones se ignorarán y no se encolará nada mientras el
//      consumidor esté ocupado.
//  3. ERROR
//      Si el consumidor no se puede nivelar con el productor se produce una señal de error.
//  4. LATEST
//      Solo mantiene las últimas emisiones hasta que el consumidor esta listo para recibirlas.
//  5. MISSING
//      No se implementa backPressure y el consumidor debe tratar con el desbordamiento backPressure.
public class FlowableCreation {

    public static void main(String[] args) throws InterruptedException {

        Flowable.create(emitter -> {
            for (int i = 0; i <= 5000; i++) {
                if (emitter.isCancelled()) return;
                emitter.onNext(i);
            }

            emitter.onComplete();;
        }, BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);

        Thread.sleep(2000);;

    }
}
