package com.jmmunoz.reactive.r05_concurrency_and_parallelization.r02_schedulers;

// RxJava dispone de diferentes schedulers para diferentes tipos de tareas.
// 1. Computation Scheduler
//      El método es: Schedulers.computation()
//      Se usa para computación de tareas intensivas, como algoritmos, lógica matemática compleja.
//      Este scheduler mantiene un número fijo de threads igual al número de CPUs o cores disponible en la sesión Java.
//      Estos cores disponibles se puede saber cuantos son ejecutando:
//          Runtime.getRunTime().availableProcessors()
//      Intentar trabajar con más threads que cores da lugar a problemas de rendimiento.
//      Si no tenemos claro que scheduler usar, entonces lo mejor es usar este.
// 2. IO Scheduler
//      El método es: Schedulers.io()
//      Se usa para operaciones intensivas de entrada/salida, como operaciones en bases de datos, llamadas HTTP...
//      En este caso los threads suelen estar sin trabajar la mitad del tiempo porque están esperando que la data
//      se envíe o se devuelva.
//      Por eso, el número de threads puede ser mayor que el número de cores.
//      El IO Scheduler mantendrá tantos threads como tareas haya y crecerá la caché dinámicamente o reducirá el
//      número de threads según sea necesario.
// 3. NewThread Scheduler
//      El método es: Scheduler.newThread()
//      Crea un thread por Observer y destruirá el thread cuando haya terminado su tarea.
//      Es muy útil cuando deseamos crear, usar y luego destruir un thread para no consumir memoria.
// 4. Single Scheduler
//      El método es: Schedulers.single()
//      Se usa cuando queremos ejecutar tareas secuencialmente, para todos los Observers, en un único thread.
//      Es útil para ejecutar operaciones de guardado non-thread.
// 5. Trampoline Scheduler
//      El método es: Schedulers.trampoline()
//      Se usa principalmente por RxJava, en su implementación interna.
//      Evita casos de scheduling recursivo, donde tareas planifican tareas en el mismo thread.
//      En vez de causar un error Stack Overflow, este scheduler permitirá al thread actual finalizar y luego ejecutar
//      la nueva tarea planificada
// 6. Scheduler.from()
//      El método es: Scheduler.from(executorService)
//      Crea un scheduler a partir de un executorService estándar Java.
public class r01_Schedulers {
}
