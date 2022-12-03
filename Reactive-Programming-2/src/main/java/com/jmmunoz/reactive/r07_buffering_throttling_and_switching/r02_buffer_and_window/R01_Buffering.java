package com.jmmunoz.reactive.r07_buffering_throttling_and_switching.r02_buffer_and_window;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

// Vimos en r05 un problema al usar schedulers con Observables, y era que a veces podía pasar que los Observables
// emitiesen data más rápidamente de lo que el Observer puede consumir.
// Esta situación puede manejarse usando Flowable (ver r08) en vez de Observables.
// Flowables son Observables con una propiedad llamada BackPressure.
// Pero hay algunos eventos que no pueden manejarse con Flowables, por ejemplo, eventos de entrada de usuario, porque
// no se puede decir al usuario que teclee más despacio.
// Para estos casos RxJava dispone de operators para agrupar (batch up) emisiones en trozos de datos (data chunks)
// para que el Observer pueda consumirlos más fácilmente.
// Hay 4 operadors:
// 1. buffer()
//      Se usa para, primero reunir las emisiones en un ámbito especificado, y luego emitir cada grupo como una
//      colección, en vez de emitir un item cada vez.
//      El ámbito se puede definir:
//      - Tamaño fijo: buffer(int count)
//      - Lapso de tiempo: buffer(long timespan)
//      - Observable: buffer(Observable boundaryIndicator)
// 2. window()
//      Parecido a buffer(), pero se hace el buffer en otros Observables en vez de en colecciones.
//      Produce un Observable de Observables. Emiten inmediatamente tan pronto como están disponibles.
//      El ámbito se puede definir:
//      - Tamaño fijo: window(int count)
//      - Lapso de tiempo: window(long timespan)
//      - Observable: window(Observable boundaryIndicator)
//      El resultado son Observables y podemos usar el operador flatMap para transformarlo en una colección
//      y ver los valores.
//      Ver ejemplo en R02_Windowing
// 3. throttle()
//      En concreto throttleFirst(), throttleLast() o sample(), throttleLatest() y throttleWithTimeOut() o debounce()
//      Ver r02_buffer_and_window
// 4. switchMap()
public class R01_Buffering {

    public static void main(String[] args) throws InterruptedException {

        // Ejemplo buffer(int count)
        // Un chunk contiene 4 emisiones en forma de lista por defecto. Se puede especificar el tipo de colección
        // pasando una lambda.
        // En el ejemplo se ha indicado un HashSet
        // También se puede indicar el valor usado para el chunk.
        Observable.range(1, 30)
                .buffer(4, HashSet::new)
                // Ejemplo indicando el valor usado para el chunk. Si es de 4 emisiones, pero tiene en cuenta 7,
                // los chunks muestran 4 elementos y dejan sin mostrar 3 (hasta llegar a 7)
                //.buffer(4, 7)
                .subscribe(System.out::println);

        System.out.println();

        // Ejemplo buffer(long timespan)
        // Se puede indicar un máximo, como en el ejemplo donde se indica que como mucho los chunks
        // serán de 2 emisiones.
        // Como es un buffer basado en tiempo, opera en Schedulers.computation()
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS, 2)
                .subscribe(System.out::println);

        Thread.sleep(8000);

        System.out.println();

        // Ejemplo buffer(Observable boundaryIndicator)
        // Se usa el timing de interval como Buffer. Emite cada segundo, tal y cmo indica el interval.
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(interval)
                .subscribe(e -> System.out.println("Emisión:" + e));

        Thread.sleep(8000);
    }
}
