package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r03_subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class R02_Subjects_With_Scheduler {

    public static void main(String[] args) throws InterruptedException {
        // Ejemplo de uso de subject para múltiples fuentes Observables. Es decir, el subject funcionará como
        // Observer de esas fuentes de emisiones.
        // Trabajando con Schedulers
        Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        Observable<Integer> src2 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

        // En este caso tampoco obtenemos todas las emisiones aunque están trabajando en paralelo y los subscribers se
        // ejecutarán en diferentes threads. Obtenemos todas las emisiones de src1 y algunas de src2.
        // Además, se están subscribiendo al subject a la vez en vez de secuencialmente.
        //
        // En este caso vemos que los subjects se pueden usar para UNIR las emisiones de múltiples fuentes.
        PublishSubject<Integer> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println(e));

        src1.subscribe(subject);
        src2.subscribe(subject);

        Thread.sleep(4000);
    }
}
