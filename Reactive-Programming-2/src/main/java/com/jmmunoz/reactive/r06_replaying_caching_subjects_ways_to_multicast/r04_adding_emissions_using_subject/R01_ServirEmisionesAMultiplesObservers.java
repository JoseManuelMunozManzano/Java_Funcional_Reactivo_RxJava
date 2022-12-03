package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r04_adding_emissions_using_subject;

import io.reactivex.rxjava3.subjects.PublishSubject;

// Este caso es el reverso del estudiado en r03_subjects
// Primero llamamos a subscribe() y después invocamos onNext() para pasar la data.
// Esto hay que hacerlo asi porque los subjects son Hot.
// Si invocamos onNext() antes de configurar el Observer, este nunca obtendrá las emisiones.
public class R01_ServirEmisionesAMultiplesObservers {

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("Observer 2: " + e));

        // Métodos onNext(), onError() y onComplete() aplicados al Subject
        subject.onNext("Hello");
        subject.onNext("Adri");
        subject.onComplete();

        // Esta emisión no se incluye puesto que ya se completó
        subject.onNext("José");
    }
}
