package com.jmmunoz.reactive.r03_rxjava_operators.r01_what_are_operators;

import io.reactivex.rxjava3.core.Observable;

// Los Operators nos permiten transforamr, modificar, unir y reducir data emitida por un Observable.
// Devuelven otro Observable que contiene esa data modificada.
// Observable<T> ----> Observable<R>
// Donde los tipos T y R pueden o no ser iguales.
public class Operators {

    public static void main(String[] args) {

        Observable.just(60, 57, 89, 90, 23, 100, 98)
                .filter(e -> e > 75)
                .sorted()
                .subscribe(e -> System.out.println("Grade A with " + e));

    }
}
