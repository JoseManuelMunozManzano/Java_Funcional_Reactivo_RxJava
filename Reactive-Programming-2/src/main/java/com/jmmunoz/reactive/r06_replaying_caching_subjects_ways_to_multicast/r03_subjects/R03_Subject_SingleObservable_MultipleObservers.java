package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r03_subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

// En este caso se va a realizar una prueba de Subject con un solo Observable y múltiples Observers.
public class R03_Subject_SingleObservable_MultipleObservers {

    public static void main(String[] args) throws InterruptedException {
        // Una sola fuente de data.
        // Trabajando con Schedulers
        Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        // Subject con más de un observer
        // Ejecuta en el orden en el que nos subscribimos al subject.
        PublishSubject<Integer> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println(e));
        subject.subscribe(e -> System.out.println("The element is: " + e));

        src1.subscribe(subject);

        Thread.sleep(9000);
    }
}
