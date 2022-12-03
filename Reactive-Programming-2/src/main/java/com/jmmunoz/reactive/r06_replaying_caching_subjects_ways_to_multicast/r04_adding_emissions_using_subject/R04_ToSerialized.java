package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r04_adding_emissions_using_subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

// Otra cosa importante es que los subjects no son Thread Safe, es decir, si muchos threads llaman onNext(),
// onComplete(), onError() o onSubscribe() las emisiones se pueden solapar y esto no es aceptable porque
// las emisiones deben suceden de forma secuencial.
// Para esto tenemos el método toSerialized() que podemos invocar en el subject para crear un serializado seguro.
public class R04_ToSerialized {

    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        // Creando un serializado seguro
        Subject<String> serialized = subject.toSerialized();

        serialized.subscribe(System.out::println);
        serialized.subscribe(e -> System.out.println("Observer 2: " + e));


        serialized.onNext("Hello");
        serialized.onNext("Adri");
        serialized.onComplete();
    }
}
