package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r03_subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

// Los subjects son un tipo de Bridge o Proxy que pueden actuar tanto como Observer como Observable, es decir,
// pueden Observar la data de múltiples fuentes y pueden emitir data a múltiples Observers, ya que
// implementa tanto Observer como Observable, así que pueden servir tanto para salida como para entrada.
// Los subjects funciones también como Multicast, es decir, todos los Observers que se subscriban recibirán las mismas
// emisiones.
//
//           Observables
//             | | |
//             v v v    implements Observer<T>
//            SUBJECT
//             | | |    extends Observable<T>
//             v v v
//           Observers
public class R01_Subjects {

    public static void main(String[] args) {
        // Ejemplo de uso de subject para múltiples fuentes Observables. Es decir, el subject funcionará como
        // Observer de esas fuentes de emisiones.
        Observable<Integer> src1 = Observable.just(5, 10, 15, 20);
        Observable<Integer> src2 = Observable.just(50, 100, 150, 200);

        // Un observer se subscribe a los dos observables.
        // Forma "normal" de suscribirse.
        // Se emiten los datos de ambas fuentes.
        //src1.subscribe(e -> System.out.println(e));
        //src2.subscribe(e -> System.out.println(e));

        // Vamos a ver la diferencia de subject con las suscripciones "normales"
        // Solo obtenemos las emisiones de src1. Esto es por el MULTICASTING.
        // Cuando los subjects se subscriben a src1 comienza la ejecución que el observer pasa (el println())
        // Por eso no obtenemos las emisiones de src2.
        PublishSubject<Integer> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println(e));

        src1.subscribe(subject);
        src2.subscribe(subject);
    }
}
