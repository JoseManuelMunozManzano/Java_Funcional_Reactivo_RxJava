package com.jmmunoz.reactive.r02_observable_and_observers.r04_hot_and_cold_observables;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

// Los observables se clasifican como:
//  A nivel de comportamiento, cuando hay muchos observers, tenemos dos tipos de Observables:
//  1. Cold
//  2. Hot
// Imaginar que un Observer se subscribe al Observable y obtiene la data, pero tras esto la data se modifica.
// Ahora, si hay más Observers, Los otros Observers obtendrán la data modificada o la data anterior sin modificar?
// Este es el criterio que decide cuando un Observable es Cold o Hot
//
// En un Cold Observable el segundo Observer obtiene la data desde el principio.
//
// Un Hot Observable comienza cuando se crea, es decir, no espera a ningún subscriptor y todos los observers
// obtienen la misma data del Observable. Cualquier nueva subscripción NO comienza desde el principio y todos los
// Observers obtendrán el item emitido a la vez. Básicamente es independiente de la subscripción de Observers.
// Se verán en r05_connectable_observables
public class HotColdObservables {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(16);
        list.add(17);
        list.add(18);

        Observable<Integer> source = coldObservable(list);

        source.subscribe(System.out::println);

        System.out.println(" ------------------ ");

        list = getData(list);

        source.subscribe(System.out::println);
    }

    private static Observable<Integer> coldObservable(List<Integer> list) {
        return Observable.fromIterable(list);
    }

    private static List<Integer> getData(List<Integer> list) {
        list.add(19);
        return list;
    }
}
