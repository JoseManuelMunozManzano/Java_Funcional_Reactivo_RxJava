package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r01_introduction;

// Replaying y Caching son formas de replicar las emisiones a los Observers porque no podemos controlar cuando se
// realizan las suscripciones.
// Subjects son el link entre los Observables y los Observers.
// Los tres se usan para reducir trabajo duplicado (multicasting) en RxJava.
//
// Hacer Multicasting de un evento consiste en enviar el mismo evento por toda la cadena de Observers o Subscribers.
// Ese evento no vuelve a recuperarse de la fuente.
// Esto es muy útil cuando se hace una operación costosa, como una petición de red. No queremos repetir exactamente
// la misma petición por cada subscriber. Lo queremos hacer una vez y hacer el multicasting del resultado a todos los
// Subscribers.
//
// Una forma que ya se vio de conseguir multicasting fue cuando convertíamos Cold Observables en Hot Observables.
// La diferencia es que Replaying y Caching no re-emiten las emisiones, sino que las emisiones son cacheadas y se
// emiten de nuevo.
public class r01_Introduction {
}
