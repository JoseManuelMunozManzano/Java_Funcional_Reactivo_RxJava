package com.jmmunoz.reactive.r04_combining_rxjava_observables.r01_merging_and_concatenating;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

// Se van a fusionar y a concatenar múltiples Observables
//
// Al fusionar con el método merge() la emisión de múltiples Observables obtenemos una única fuente Observable.
// Dependiendo de en qué método se va a hacer el fusionado obtendremos un tipo u otro de emisiones desde este
// Observable.
// Una firma es:
// Observable.merge(source1, source2)
// Pero hay muchas más.
// Ante una excepción en cualquiera de los Observables emisores la subscripción se cancela y
// no se aceptan más emisiones
//
// Para concatenar se usa el método concat() y una de sus firmas es:
// Observable.concat(source1, source2)
// Hay firmas para permitir hasta 4 observables emisores.
// Se mantiene el orden secuencial de los observables emisores, es decir, primero las emisiones de source1 y luego
// las emisiones de source2
public class MergeAndConcat {

    public static void main(String[] args) throws InterruptedException {

        // Uso de merge()
        Observable<String> src1 = Observable.just("Adri", "José", "Tania");
        Observable<String> src2 = Observable.just("Marina", "Maricarmen");

        // En un programa secuencial se emite primero src1 y luego src2.
        // Sería igual a concat
        Observable.merge(src1, src2)
                .subscribe(e -> System.out.println("Received: " + e));

        System.out.println();

        Observable<String> src3 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src3: " + e);
        Observable<String> src4 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src4: " + e);

        // Desde diferentes threads, la salida es impredecible.
        Observable.merge(src3, src4)
                .subscribe(e -> System.out.println("Received: " + e));

        Thread.sleep(6000);

        System.out.println();

        // Uso de concat()
        Observable<String> src5 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src5: " + e);
        Observable<String> src6 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src6: " + e);

        // Salida secuencial, a diferencia de con merge()
        Observable.merge(src5, src6)
                .subscribe(e -> System.out.println("Received: " + e));

        // Otra forma de invocar concat()
        src5.concatWith(src6)
                .subscribe(e -> System.out.println("Received: " + e));

        Thread.sleep(6000);
    }
}
