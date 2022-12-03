package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r04_adding_emissions_using_subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class R03_Add_Emisions {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
                .subscribeOn(Schedulers.computation());

        Observable<Integer> src2 = Observable.just(50, 100, 150, 200)
                .subscribeOn(Schedulers.computation());

        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println(e));

        // Añadiendo emisiones
        // Son las primeras que se ejecutan.
        // Si hubiera un onComplete tras Hello, solo se emitiría Hello.
        // Pero esto puede ser peligroso porque si exponemos el subject, cualquiera puede pasar emisiones.
        // Es mejor, por tanto, mantener las fuentes de datos Cold, o si deben ser Hot, hacer Multicasting usando
        // los métodos publish() o replay()
        // También se puede hacer un cast a Observable o envolverlo en una clase implementando internamente los
        // métodos onNext(), onError() y onComplete() para controlar la secuencia.
        subject.onNext("Hello");
        subject.onNext("Adri");

        src1.subscribe(subject);
        src2.subscribe(subject);

        Thread.sleep(9000);
    }
}
