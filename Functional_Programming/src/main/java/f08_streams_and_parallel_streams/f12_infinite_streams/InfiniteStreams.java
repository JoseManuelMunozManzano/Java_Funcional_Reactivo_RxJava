package f08_streams_and_parallel_streams.f12_infinite_streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {

    public static void main(String[] args) {
        // Formas de crear streams infinitos
        // Se pueden limitar con el método limit()

        // 1. Usando el método iterate()
        // Hay que pasarle una semilla que será el primer elemento del stream y un operador unary
        Stream.iterate(0, i -> i + 1);

        // También puede usarse el método iterate() en Streams primitivos
        IntStream.iterate(0, i -> i - 1)
                .limit(15)
                .forEach(System.out::println);

        // 2. Usando el método generate()
        // Hay que pasarle un Supplier (no toma nada pero retorna algo) y se generará infinitas veces o hasta que
        // se alcance el límite si se ha puesto.
        // Se usa bastante cuando se quiere por ejemplo un stream de números aleatorios.
        Stream.generate(() -> "Hello")
                .limit(3)
                .forEach(System.out::println);

        Stream.generate(new Random() :: nextInt)
                .limit(8)
                .forEach(System.out::println);
    }
}
