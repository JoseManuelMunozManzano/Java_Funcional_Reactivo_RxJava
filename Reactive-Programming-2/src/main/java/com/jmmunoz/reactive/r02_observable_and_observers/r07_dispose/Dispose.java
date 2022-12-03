package com.jmmunoz.reactive.r02_observable_and_observers.r07_dispose;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

// Vamos a ver como un Observer que se ha suscrito a un Observable se puede dar de baja (unsubscribe) de un Observable.
// Para ello se usa el método dispose()
// Supongamos que trabajamos con Observables no limitados que no paran de emitir data, y para un Observer concreto
// no queremos seguir emitiendo data. En este escenario podemos darnos de baja del Observable.
public class Dispose {

    // Para hacer el dispose() de múltiples subscripciones a la vez, se puede usar un CompositeDisposable
    private static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);

        // Digamos que el primer Observer solo quiere 5 emisiones
        @NonNull
        Disposable d = src.subscribe(e -> System.out.println("Observer 1: " + e));
        Thread.sleep(5000);
        d.dispose();

        // Con clase anónima
        src.subscribe(new Observer<Long>() {
            private Disposable d;

            // Tras inicializar Disposable todos los demás métodos en este Observer tendrán acceso al objeto Disposable,
            // ya que el primer método al que se llama en la subscripción es onSubscribe()
            // Por tanto, si nos damos de baja en la llamada a subscribe() no obtendremos emisiones.
            //
            // Y si creamos un Observable propio que va a emitir una gran cantidad de elementos, antes de retornarlos
            // con onNext() debemos confirmar si se ha llamado al método dispose() y si es así parar la emisión.
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(@NonNull Long aLong) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        // Este Observer si quiere recibir todas las emisiones
        src.subscribe(e -> System.out.println("Observer 3: " + e));

        Thread.sleep(10000);



        System.out.println();
        // Ejemplo de CompositeDisposable
        @NonNull
        Disposable d1 = src.subscribe(e -> System.out.println("Observer cd1: " + e));
        @NonNull
        Disposable d2 = src.subscribe(e -> System.out.println("Observer cd2: " + e));

        Thread.sleep(5000);

        // Añadimos todos los disposables y sobre ellos ejecutamos el método dispose()
        // Para ambos solo obtenemos 5 emisiones
        disp.addAll(d1, d2);
        disp.dispose();

        Thread.sleep(5000);
    }
}
