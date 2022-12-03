package com.jmmunoz.reactive.r02_observable_and_observers.r02_creating_observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Se van a estudiar varias formas de crear un observable
public class CreatingObservable {

    public static void main(String[] args) {

        // 1. Usando el método create(source) con una lambda
        //    Apenas se usa porque introducimos "a mano" en el onNext(), onComplete() y onError() los valores.
        Observable<Integer> source = Observable.create(
            e -> {
                e.onNext(10);
                e.onNext(11);
                e.onNext(12);
                e.onComplete();
                // Con un try-catch se puede implementar el onError() también
            }
        );

        // Nos subscribimos. El observer es directamente la salida por consola.
        source.subscribe(System.out::println);

        System.out.println(" ------------------ ");

        // 2. Usando el método just(1Upto9Items...)
        //    Pasamos los valores y los métodos onNext(), onComplete() y onError() son llamados implicitamente por
        //    el método just()
        //    Como mucho se pueden pasar 9 elementos.
        Observable<Integer> just = Observable.just(1, 2, 3);

        just.subscribe(System.out::println);

        System.out.println(" ------------------ ");

        // 3. Usando el método fromIterable()
        //    Para crear un observable a partir de un iterable
        List<String> list = List.of("Adri", "José", "Tania");
        Observable<String> fromIterable = Observable.fromIterable(list);

        fromIterable.subscribe(System.out::println);

        System.out.println(" ------------------ ");

        // Otras formas de crear Observables son
        // 4. range(startValue, totalCount)
        //    rangeLong(startValue, totalCount)
        Observable.range(3, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));

        System.out.println(" ------------------ ");

        // 5. Observable.interval(period, unit)
        //    Como es un Observable basado en tiempo operan con un temporizador y necesitan ejecutarse en un thread
        //    separado, ejecutándose por defecto en el planificador.
        //    Así que el método main va a parar este Observable porque el método main se completa y corre en un
        //    thread diferente y no va a esperar a que el Observable termine. Por eso se invoca el sleep.
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
        try {
            interval.subscribe(System.out::println);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" ------------------ ");

        // 6. Observable.future(future)

        // 7. Observable.empty()
        //    No emite nada y llama a la acción onComplete(), es decir, para que esto tenga sentido hay que
        //    implementar onComplete() y se invocará.

        // 8. Observable.never()
        //    No emite nada ni llama a la acción onComplete()
        //    Se usa para testing para probar que no hay emisiones.
        //    Al igual que en Observable.interval() también hay que usar sleep() porque el método main no va a esperar
        //    a que acabe.

        // 9. Observable.error(ExSupplier)
        //    Suministra una excepción de forma intencionada, como se haría con la palabra reservada throw en estilo
        //    imperativo

        // 10. Observable.defer(supplier)
        //     Crea un estado separado para cada Observer
        List<String> list2 = new ArrayList<>();
        list2.add("Adri");
        list2.add("José");
        // El supplier también devuelve un Observable
        Observable<String> defer = Observable.defer(() -> Observable.fromIterable(list2));
        defer.subscribe(System.out::println);

        list2.add("Maricarmen");
        // Se escriben los 3 nombres (no solo Maricarmen)
        defer.subscribe(System.out::println);

        // 11. Observable.fromCallable(Callable)
        //     Se pasa un callable para crear un Observable
    }
}
