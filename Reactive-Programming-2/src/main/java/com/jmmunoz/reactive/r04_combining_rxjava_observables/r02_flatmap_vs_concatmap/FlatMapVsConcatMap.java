package com.jmmunoz.reactive.r04_combining_rxjava_observables.r02_flatmap_vs_concatmap;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

// Estos dos operadores hacer el merge y el concat de UN Observable
// FlatMap hace el merge de las emisiones
// ConcatMap hace el concat de las emisiones
// Pero la aplicación es completamente diferente a merge() y concat()
// Solo tenemos un Observable que toma una función mapper. Su firma es:
// source.flatMap(mapper);
// Y devuelve un Observable
public class FlatMapVsConcatMap {

    public static void main(String[] args) {

        List<String> list = List.of("Hello", "Reactive", "Programming");

        // Si fuera ejecución concurrente la salida de caracteres sería impredecible
        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

        System.out.println();

        // Si fuera ejecución concurrente la salida de caracteres sería tal y como se emite
        Observable.fromIterable(list)
                .concatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}
