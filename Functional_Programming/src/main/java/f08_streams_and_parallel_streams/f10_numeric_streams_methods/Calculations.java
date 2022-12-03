package f08_streams_and_parallel_streams.f10_numeric_streams_methods;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculations {

    public static void main(String[] args) {
        // IntStream
        // DoubleStream
        // LongStream

        // sum() devolverá primitivos int, double o long, dependiendo del tipo de Stream numérico.
        // Si el stream está vacío, el resultado obtenido es 0
        int sum = IntStream.of(1, 2, 3, 4)
                .sum();

        System.out.println(sum);

        // max() devuelve un Optional primitive
        // Un stream vacío no da como resultado del método max() el valor 0 porque podría haber números negativos
        // Es decir, el valor 0 no necesariamente es el valor mínimo.
        // Lo que obtenemos es un empty Optional
        OptionalInt maxOptional = IntStream.of(1, 2, 3, 4)
                .max();

        System.out.println(maxOptional.getAsInt());

        // min() devuelve un Optional primitive
        OptionalInt minOptional = IntStream.of(1, 2, 3, 4)
                .min();

        System.out.println(minOptional.getAsInt());

        // average() devuelve un OptionalDouble
        OptionalDouble avgOptional = IntStream.of(1, 2, 3, 4)
                .average();

        System.out.println(avgOptional.getAsDouble());

        // summaryStatistics() sirve para calcular los valores máximo, mínimo, media y suma de una vez
        IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 34)
                .summaryStatistics();

        System.out.println(summaryStatistics);
    }
}
