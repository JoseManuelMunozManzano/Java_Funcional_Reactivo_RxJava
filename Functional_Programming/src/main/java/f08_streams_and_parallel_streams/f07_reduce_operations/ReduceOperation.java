package f08_streams_and_parallel_streams.f07_reduce_operations;

import java.util.stream.Stream;

public class ReduceOperation {

    public static void main(String[] args) {
        // reduce se usa por ejemplo para sumar elementos de una lista, o encontrar un máximo o un mínimo...
        // Reduce es un proceso de repetición de combinación de todos los elementos para obtener un resultado.
        // Su firma es:
        // T reduce(<T> identity, BinaryOperator op)
        // Donde identity es el valor inicial al iniciar una operación y BinaryOperator es un acumulador

        Integer sum = Stream.of(1, 2, 34, 56, 76, 87, 89, 90)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
    }
}
