package r01_introduction.r05_concurrency_vs_parallel_program;

// Concurrency: ejecutar múltiples partes de un programa (tareas) en una CPU usando hilos.
//    Se consigue en Java utilizando múltiples hilos.
// Parallelism: las tareas se ejecutan al mismo tiempo, por ejemplo, en un procesador multicore. Las tareas
//    se rompen y se ejecutan en distintas CPUs y luego se combinan los resultados para obtener el resultado final.
//    Se consigue en Java utilizando fork-join pool.
//
// RxJava provee de una mejor abstracción para conseguir concurrencia y paralelismo.
public class ConcurrencyVsParallel {
}
