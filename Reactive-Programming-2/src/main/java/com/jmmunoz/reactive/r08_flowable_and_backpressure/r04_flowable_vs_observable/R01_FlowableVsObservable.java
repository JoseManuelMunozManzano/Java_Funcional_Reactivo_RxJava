package com.jmmunoz.reactive.r08_flowable_and_backpressure.r04_flowable_vs_observable;

// Tanto Observable como Flowable son entidades que pueden ser observadas por Observer o Subscriber.
// Flowable es una implementación de flujo reactivo (Reactive Streams) diferente a Observable, y soporta
// backPressure, que como hemos visto, es una técnica que para tratar con productores muy rápidos de items.
//
// Usamos Flowable:
// - Cuando esperamos una gran cantidad de emisiones y necesitamos realizar operaciones complejas sobre ellas.
// - Cuando tenemos Hot Observables que emiten data continuamente.
// - Cuando tenemos fuentes asíncronas y programación concurrente y paralela.
// - Cuando queremos manejar emisiones de operaciones IO, porque casi todas las operaciones IO soportan bloqueo
//   a la vez que devuelven un resultado, se pueden pausar y reanudar fácilmente, y eso es exáctamente lo que hacemos
//   con los Flowables.
//
// Usamos Observable:
// - Cuando tenemos emisiones continuas que no son muchas o cuando los eventos emiten data de forma perezosa.
//   En este caso Observable es más rápido, ya que tiene menos gasto computacional que un Flowable.
// - Cuando la fuente es síncrona y tenemos una concurrencia limitada (método subscribeOn(), flatMap(), zip(), delay())
// - Cuando trabajamos con eventos de usuario, eventos de tiempo (métodos buffer(), window(), throttleFirst(),
//   debounce(), switchMap())
public class R01_FlowableVsObservable {
}
