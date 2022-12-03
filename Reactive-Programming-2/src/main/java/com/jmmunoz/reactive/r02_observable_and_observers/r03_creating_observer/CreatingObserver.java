package com.jmmunoz.reactive.r02_observable_and_observers.r03_creating_observer;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {

    public static void main(String[] args) {
        // Dado un Observable
        Observable<String> source = Observable.just("Naranja", "Negro", "Rojo");

        // Estas son las diferentes formas de crear un Observer

        // 1. Creando una clase interna anónima como se vio en: r01_observable_observer/ObservableAndObserver.java

        // 2. Usar 3 lambdas para crear las 3 eventos
        //    La primera lambda es para el evento onNext()
        //    La segunda lambda es para el evento onError()
        //    La tercera lambda es para el evento onComplete()
        source.subscribe(i -> System.out.println(i),
                Throwable::printStackTrace,
                () -> System.out.println("Completed!"));

        System.out.println(" ------------------ ");

        // 2. Usar 2 lambdas para crear 2 eventos
        //    La primera lambda es para el evento onNext()
        //    La segunda lambda es para el evento onError()
        //    NO se señaliza la terminación, onComplete(), de la emisión
        // Es útil si hay un número infinito de emisiones.
        source.subscribe(i -> System.out.println(i),
                Throwable::printStackTrace);

        System.out.println(" ------------------ ");

        // 3. Usar 1 lambda para crear el evento onNext()
        source.subscribe(i -> System.out.println(i));
    }
}
