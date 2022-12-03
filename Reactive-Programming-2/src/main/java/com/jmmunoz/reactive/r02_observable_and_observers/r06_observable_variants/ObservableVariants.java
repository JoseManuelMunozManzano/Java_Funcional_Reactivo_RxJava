package com.jmmunoz.reactive.r02_observable_and_observers.r06_observable_variants;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

// Tipos de Observables que tienen un propósito ligeramente diferente:
// 1. Single
//  Es un Observable que solo emitirá un item. Muy útil cuando tenemos solo un resultado.
//  Esta es su interface
//      interface SingleObserver<T> {
//          void onSubscribe(Disposable d);
//          void onSuccess(T value);
//          void onError(Throwable error);
//      }
//  onSuccess() invoca onNext() con el único elemento que tiene y luego ejecuta onComplete()
//
// 2. Maybe
//  Es un Observable que emite cero o un item. Es útil si, por ejemplo, queremos saber si en nuestra BBDD existe o no
//  un usuario.
//  Esta es su interface
//      interface MaybeObserver<T> {
//          void onSubscribe(Disposable d);
//          void onSuccess(T value);
//          void onError(Throwable error);
//          void onComplete();
//      }
// onSuccess() invoca onNext()
// En caso de que haya emisión se llamará a onSuccess() y luego onComplete()
// En caso de que no haya emisiones se llamará a onComplete() directamente
//
// 3. Completable
//  Es un Observable que no emite ninguna data. Solo se preocupa de la acción que se ejecuta, si ha sido exitosa o
//  errónea. Es útil cuando queremos ejecutar algún proceso y podemos crear un Completable.fomRunnable() y ejecutar
//  dicho proceso, y tras la terminación de ese proceso ejecutar el método onComplete() proporcionado por el Observer.
//  Esta es su interface
//      interface CompletableObserver<T> {
//          void onSubscribe(Disposable d);
//          void onComplete();
//          void onError(Throwable error);
//      }
//  Vemos que no tiene métodos onSuccess() o onNext()

public class ObservableVariants {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Adri", "José", "Maricarmen");
        Observable<String> empty = Observable.empty();

        // Ejemplo con Single
        // Queremos encontrar el primer elemento emitido desde el Observable source
        source
                .first("Name")
                .subscribe(System.out::println);

        // Si no hay elementos se emite el valor por defecto
        empty
                .first("Name")
                .subscribe(System.out::println);

        // Para crear un Single
        Single.just("Adri")
                .subscribe(System.out::println);



        // Ejemplo con Maybe
        System.out.println();
        source
                .firstElement()
                .subscribe(System.out::println);

        // No se obtiene item y se llama a onComplete()
        // Nota: no es obligatorio implementar los 3 métodos
        empty
                .firstElement()
                .subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("Completed!"));

        // Creando un Maybe
        Maybe.just("José")
                .subscribe(System.out::println);



        // Ejemplo con Completable
        System.out.println();
        Completable completable = Completable.complete();
        completable.subscribe(() -> System.out.println("Completed!"));

        // Ejemplo de Completable.fromRunnable()
        Completable
                .fromRunnable(() -> System.out.println("Some process executing..."))
                .subscribe(() -> System.out.println("The process executed succesfully!"));
    }
}
