package f08_streams_and_parallel_streams.f15_stateless_and_stateful_operations;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessAndStateful {

    public static void main(String[] args) {
        // Operaciones Stateless
        //      Se ejecutan uno por uno en los elementos streams
        //      No necesitan ningún tipo de información del exterior

        // Operaciones Stateful
        //      Usan información del exterior

        List<Integer> list = List.of(1, 2, 4, 5, 6, 7, 9);

        List<Integer> collect = list
                .parallelStream()
                .skip(2)        // No realizamos operación sobre el segundo elemento
                .limit(5)   // Limitamos el stream a 5 elementos
                .collect(Collectors.toList());

        // Si se ejecuta en paralelo, Cuál es el segundo elemento?
        // Y como saben los hilos que se han procesado 5 elementos?
        // En este caso no es bueno usar paralelismo porque estas operaciones son difíciles de procesar en paralelo.

        // Java indica en su documentación que operaciones son stateless y cuales son stateful.
        // En este caso, tanto skip como limit son operaciones stateful.
    }
}
