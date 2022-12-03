package com.jmmunoz.reactive.r02_observable_and_observers.r01_observable_observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {

    public static void main(String[] args) {

        // En vez de escribir una lambda se va a implementar una clase interna anónima porque se quiere
        // poner el foco en como se implementa un Observable.
        // ObservableOnSubscribe es una interface que define la acción a tomar cuando un subscriber u observador
        //   se subscribe a este observable.
        // No es necesario memorizar esto porque es mucho más fácil de diseñar con una labmda.
        //
        // Los datos son suministrados por el observable
        Observable<Integer> source = new ObservableCreate<>(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                // Se indica:
                // onNext() para ver que valores se van cogiendo
                // onComplete() para indicar cuando se completa
                // onError() para indicar que ha ocurrido un error
                try {
                    emitter.onNext(10);
                    emitter.onNext(11);
                    emitter.onComplete();
                } catch (Throwable t) {
                    emitter.onError(t);
                }
            }
        });

        // Creación de un observer
        // El observer tiene la implementación de cómo se tienen que manejar los datos suministrados por el observable
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(@NonNull Integer t) {
                System.out.println("On Next: " + t);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");
            }
        };

        // Al observable se subscribe el observer
        source.subscribe(observer);
    }
}
