package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r03_subscribe_on;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Se usa subscribeOn() para permitir que un Observer se subscriba a un Observable en un thread particular.
// Hay dos cosas sobre la posición del operador onSubscribe() en la cadena del Observable:
// 1. La posición no importe
// 2. La posición importa: Cuando hay más de una llamada subscribeOn() u observeOn()
// Si tenemos más de una llamada a subscribeOn() con diferentes schedulers, el que está más cerca al source gana.
public class SubscribeOn {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())      // Se usa este Scheduler, el más cercano al source
                .map(e -> e.toUpperCase())
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .subscribeOn(Schedulers.newThread())
                .filter(e -> e.startsWith("P"))
                .subscribe(SubscribeOn::print);

        Thread.sleep(6000);
    }

    public static void print(String element) throws InterruptedException {
        System.out.println(element + ": Printed By: " + Thread.currentThread().getName());
    }
}
