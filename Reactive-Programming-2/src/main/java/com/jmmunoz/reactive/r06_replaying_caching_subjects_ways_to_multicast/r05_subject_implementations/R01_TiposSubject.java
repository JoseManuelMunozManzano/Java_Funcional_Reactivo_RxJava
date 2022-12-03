package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r05_subject_implementations;

// Tipos de Subject según su implementación
// 1. PublishSubject
//      El subject más básico y el que se ha usado hasta ahora.
//      Empiezan a emitir los items de los fuentes observables desde el momento que un observer se suscribe a él.
//      Un ejemplo sería tomar la televisión como un observable y al espectador como observador. Comenzamos a recibir
//      la transmisión desde el momento en que nos vamos a un canal de TV.
// 2. ReplaySubject
//      Emite todos los items de la fuente observable, independientemente de cuando se suscriben los Subscribers.
//      Es decir, hace el replay de emisiones por cada subscriber.
//      Internamente, es un PublishSubject con un operador caché.
//      Un ejemplo serían los videos de YouTube en el que, si estás viendo un video y otra persona se pone mås tarde
//      contigo, puedes empezar a ver el video de nuevo.
// 3. BehaviourSubject
//      Emite el item más reciente con los posteriores items de la fuente observable desde el punto de la suscripción.
//      Un ejemplo sería cuando estamos viendo algo en Internet, nuestros amigos se nos unen y quieren verlo desde
//      lo más reciente (no desde el comienzo)
// 4. AsyncSubject
//      Emite solo el último valor de la fuente observable tras invocar la acción onComplete()
//      No debe usarse en Observables infinitos, puesto que no se invoca nunca la acción onCmplete()
//      Un ejemplo sería cuando en Amazon Prime hay un episodio que no estamos interesados en ver, pero queremos saber
//      como acaba.
// 5. UnicastSubject
//      Mete en un buffer todas las emisiones recibidas por las fuentes, hasta que un Observer se suscribe a él.
//      En ese momento se liberan todas las emisiones del buffer y se limpia su caché.
//      Solo permite un Observer, ya que al emitir se limpia la caché.
// Funcionan de forma diferente y se usan con diferentes propósitos.
public class R01_TiposSubject {

    public static void main(String[] args) {

    }
}
