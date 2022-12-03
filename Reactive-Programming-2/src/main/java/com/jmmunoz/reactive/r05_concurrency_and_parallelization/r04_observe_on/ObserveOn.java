package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r04_observe_on;

import com.jmmunoz.reactive.r05_concurrency_and_parallelization.r03_subscribe_on.SubscribeOn;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

// Cómo se puede cambiar un scheduler en mitad de un Observable?
// Ya hemos visto que subscribeOn() no funciona.
// Se usa el operator observeOn()
// Lo que hace es interceptar la emisión en el punto donde se encuentra (el observerOn()) en la cadena del Observable
// y cambia dicha emisión al nuevo scheduler indicado.
// A diferencia de subscribeOn(), la posición donde se encuentra observeOn() importa.
//
// Usar observeOn() conlleva implicaciones de rendimiento. Cuando hay un observeOn(), las operaciones por encima de él
// se ejecutan en un scheduler diferente y entonces los elementos alcanzan la llamada observeOn(), y entonces vuelven
// a emitirse los mismos elementos usando el nuevo scheduler y siguen por la cadena restante del Observable.
// PERO el observeOn() NO espera a que el elemento complete su cadena. Su trabajo consiste solo en cambiar el scheduler,
// así que mientras el siguiente elemento alcanza el observeOn() de nuevo se emite ese elemento sin esperar que el
// actual termine de recorrer la cadena del Observable.
// Esto implica que la parte de arriba del observeOn() puede producir emisiones más rápidamente de lo que puede
// procesar la parte de abajo del observeOn()
// Esto es un problema de producer-consumer, donde el producer genera emisiones más rápido de lo que el consumer
// puede consumirlos.
// Si esto ocurre, las emisiones no procesadas se encolarán en el observeOn() hasta que su parte de abajo pueda
// procesarlas. Pero si hay muchas emisiones podemos caer en potenciales problemas de memoria.
// En este escenario se suele evitar crear Observables y, en cambio, se usan Flowables que soportan BackPressure
// (ver r08, y a partir de r06 se trata esta situación)
public class ObserveOn {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())      // Se usa este Scheduler, el más cercano al source
                .map(e -> e.toUpperCase())
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())      // Cambio de Scheduler
                .filter(e -> e.startsWith("P"))         // Pero este filter se hace en threads del Scheduler.newThread()
                .observeOn(Schedulers.io())             // Cambio de Scheduler
                .subscribe(SubscribeOn::print);         // Y este print se hace con el Scheduler.io()

        Thread.sleep(6000);
    }

    public static void print(String element) throws InterruptedException {
        System.out.println(element + ": Printed By: " + Thread.currentThread().getName());
    }
}
