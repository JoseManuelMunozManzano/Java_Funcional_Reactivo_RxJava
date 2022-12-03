package com.jmmunoz.reactive.r04_combining_rxjava_observables.r04_zip_vs_combinelatest;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

// zip toma Observables, de doa a nueve y una función zipper:
// Observable.zip(Observable1, Observable1, zipper);
// Toma ua emisión de cada Observable y los combina en una sola emisión. Se devuelve un Observable que aplica una
// función a nuestra elección para combinar los elementos emitidos.
// Ejemplo:
//    Observable 1: "One" "Two"
//    Observable 2:   1     2
// Resultado: observable{"One 1", "Two 2"}
//
// combinaLatest tiene la siguiente firma:
// Observable.combineLatest(source1, source2, combiner);
// La diferencia con zip() es que una de las fuentes de emisión no espera a la otra fuente para emitir nuevas
// emisiones.
// Ejemplo:
//    Observable 1: "One" "Two" "Three" "Four"
//    Observable 2:         1             2
// Resultado: observable{"Two 1", "Three 1", "Four 2"}
public class ZipvsCombineLatest {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(src1, src2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);


        Observable.combineLatest(src1, src2, (e1, e2) -> "CL Source 1: " + e1 + " CL Source 2: " + e2)
                .subscribe(System.out::println);

        Thread.sleep(7000);

        // No es reproducible en una ejecución secuencial. Tiene que ser con hilos
    }
}
