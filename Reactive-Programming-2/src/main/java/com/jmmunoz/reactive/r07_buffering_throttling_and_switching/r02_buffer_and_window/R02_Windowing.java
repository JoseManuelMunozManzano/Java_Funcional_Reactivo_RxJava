package com.jmmunoz.reactive.r07_buffering_throttling_and_switching.r02_buffer_and_window;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

// Ver explicación de window() en R01_Buffering
public class R02_Windowing {

    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 30)
                .window(4)
                .subscribe(System.out::println);

        System.out.println();

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .window(1, TimeUnit.SECONDS, 2)
                .subscribe(System.out::println);

        Thread.sleep(8000);

        System.out.println();

        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .window(interval)
                .subscribe(e -> System.out.println("Emisión:" + e));

        Thread.sleep(8000);

    }
}
