package com.jmmunoz.reactive.r07_buffering_throttling_and_switching.r03_throttle_operator;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

// El operador Throttle omite algunas de las emisiones cuando ocurren rápidamente.
// Es muy útil cuando algunas de esas rápidas emisiones no son requeridas o son redundantes, por ejemplo,
// cuando un usuario hace click con el ratón repetidamente, esos inputs son redundantes.
//
// Una desventaja es que retrasa la emisión por un intervalo de tiempo especificado, y a veces no es aceptable desde
// el punto de vista del usuario. Para esos casos se puede usar SwitchMap(), ver r04_switchmap
public class ThrottleOperator {

    public static void main(String[] args) {

        Observable<String> obs = Observable.create(emitter -> {
           emitter.onNext("A");

           Thread.sleep(200);
           emitter.onNext("B");

            Thread.sleep(100);
            emitter.onNext("C");

            Thread.sleep(400);
            emitter.onNext("D");

            Thread.sleep(300);
            emitter.onNext("E");

            Thread.sleep(800);
            emitter.onNext("F");

            Thread.sleep(900);
            emitter.onNext("X");

            Thread.sleep(600);
            emitter.onNext("Y");

            Thread.sleep(1000);
            emitter.onNext("Z");

            emitter.onComplete();
        });

        obs
                // Se emite el primer item que ocurre al comienzo de cada segundo
                .throttleFirst(1000, TimeUnit.MILLISECONDS)
                .subscribe(
                item -> System.out.println("onNext: " + item),      // onNext()
                Throwable::printStackTrace,                         // onError()
                () -> System.out.println("onComplete")              // onComplete()
        );

        obs
                // Se emite el último item que ocurre en cada segundo
                .throttleLast(1000, TimeUnit.MILLISECONDS)
                // También se puede indicar el método sample
                //.sample(1000, TimeUnit.MILLISECONDS)
                .subscribe(
                        item -> System.out.println("onNext with sample: " + item),      // onNext()
                        Throwable::printStackTrace,                         // onError()
                        () -> System.out.println("onComplete")              // onComplete()
        );

        obs
                // Se ejecuta un item emitido tras un tiempo concreto de inactividad de la fuente.
                // Tras emitir la fuente el tiempo se resetea.
                // En el ejemplo se emite tras 700 ms de silencio de la fuente.
                .throttleWithTimeout(700, TimeUnit.MILLISECONDS)
                // También se puede indicar el método debounce
                //.debounce(700, TimeUnit.MILLISECONDS)
                .subscribe(
                        item -> System.out.println("onNext with debounce: " + item),      // onNext()
                        Throwable::printStackTrace,                         // onError()
                        () -> System.out.println("onComplete")              // onComplete()
        );

    }
}
