package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r05_subject_implementations;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

// Este ejemplo es un poco más elaborado
// Obtenemos 4 emisiones en el mismo instante, que son las que están en el buffer en el momento en que nos suscribimos.
// Luego se emite el resto de items de uno en uno.
public class R07_UnicastSubject2 {

    public static void main(String[] args) throws InterruptedException {

        Subject<Long> subject = UnicastSubject.create();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(subject);

        Thread.sleep(2000);

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        Thread.sleep(2000);
    }
}
