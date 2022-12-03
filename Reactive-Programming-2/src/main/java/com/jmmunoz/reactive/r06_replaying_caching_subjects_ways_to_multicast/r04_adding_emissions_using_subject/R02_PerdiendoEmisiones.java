package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r04_adding_emissions_using_subject;

import io.reactivex.rxjava3.subjects.PublishSubject;

// Ejemplo en el que se pierden las emisiones porque primero se hace el onNext() y luego configuramos el Observer
public class R02_PerdiendoEmisiones {

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        subject.onNext("Hello");
        subject.onNext("Adri");
        subject.onComplete();

        // No vamos a obtener datos
        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("Observer 2: " + e));
    }
}
