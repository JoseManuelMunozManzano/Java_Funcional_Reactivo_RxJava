package com.jmmunoz.reactive.r08_flowable_and_backpressure.r01_need_of_backpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Qué es backpressure?
// La corriente de flujo normal consiste en que desde un Observable se emite un item que va transformándose según pasa
// por distintos operadores y al final llega a un Observer.
// Pero cuando se añade concurrencia o paralelización a este flujo entonces partes de este flujo operan en threads
// diferentes, es decir, si por ejemplo hay 5 operadores y el 4 es el operador observeOn(Schedulers.io()) entonces
// los 3 primeros operadores se ejecutan en el thread main y el 4, el 5 y la parte del Observer se ejecutan en otro
// thread.
// Pero el problema real es que cuando la data llega al operador 4 el Observable emite otro item sin esperar a que
// el anterior llegue al Observer.
// El Producer produce más rápido de lo que el Consumer puede consumirlo.
// y esta latencia puede llevar a problemas de memoria
//
// A esto se le llama el problema del Producer-Consumer y es lo que trata de evitar backPressure.
public class NeedOfBackPressure {

    public static void main(String[] args) {
        Observable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is: " + e + " - " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
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
