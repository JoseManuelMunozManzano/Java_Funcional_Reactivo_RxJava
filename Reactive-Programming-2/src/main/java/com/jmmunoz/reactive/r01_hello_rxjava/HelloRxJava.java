package com.jmmunoz.reactive.r01_hello_rxjava;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

    public static void main(String[] args) {
        Observable<String> source = Observable.create(e -> {
            e.onNext("Hello");
            e.onNext("RxJava");
        });

        source.subscribe(e -> System.out.println("Observer 1: " + e));
        source.subscribe(e -> System.out.println("Observer 2: " + e));
    }
}
