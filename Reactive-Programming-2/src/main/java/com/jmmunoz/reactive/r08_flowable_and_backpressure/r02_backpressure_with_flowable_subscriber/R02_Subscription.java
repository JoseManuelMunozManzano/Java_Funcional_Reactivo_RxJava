package com.jmmunoz.reactive.r08_flowable_and_backpressure.r02_backpressure_with_flowable_subscriber;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

// Ejemplo de Subscription para conseguir implementar un backPressure a nuestra conveniencia.
// Se piden 20 items, pero vemos que la primera tanda siempre produce 128, debido a que deja un extra en la cola por
// si hay algún tiempo de inactividad, tener elementos de sobra.
public class R02_Subscription {

    public static void main(String[] args) {
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is: " + e + " - " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                // Creamos el Subscriber e implementamos sus métodos
                .subscribe(new Subscriber<Integer>() {

                    // Usamos AtomicInteger porque muchos threads van a acceder y actualizarlo
                    // Necesitamos una version de Integer que sea Thread Safe.
                    Subscription subscription;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        System.out.println("Asking for 20 items");
                        subscription.request(20);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        if (count.getAndIncrement() % 20 == 0) {
                            System.out.println("Asking for next 20 items");
                            subscription.request(20);
                        }

                        System.out.println("The subscriber consumed: " + integer);

                        // Solo con propósitos de ver la data crearse en el terminal
                        sleep(100);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed!");
                    }
                });
        sleep(100000000);
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
