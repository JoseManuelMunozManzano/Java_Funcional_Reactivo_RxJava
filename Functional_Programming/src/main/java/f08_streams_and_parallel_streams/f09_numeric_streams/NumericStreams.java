package f08_streams_and_parallel_streams.f09_numeric_streams;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();

        list.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        list.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        list.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        list.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        OptionalDouble average = list.stream()
                .mapToDouble(book -> book.getRating())
                .average();     // Funcionalidad matemåtica presente en Stream primitivo

        System.out.println(average.getAsDouble());

        // La diferencia entre map y mapToDouble es que map devuelve un stream Objects.
        // (si devuelve un primitivo int lo pasa al Object Integer...)
        // y mapToDouble desempaqueta el Object Double al primitivo double.
        // map : Objects
        // mapToDouble : primitive double

        // Las ventajas de usar streams numéricos (IntStream, LongStream y DoubleStream) es que ya vienen
        // con funcionalidades matemáticas que no posee el Stream básico y que han sido desarrolladas para
        // evitar el costo del empaquetado (boxing) y desempaquetado (unboxing), es decir, tienen mejor rendimiento.

        // Forma sencilla de crear Stream primitivos
        IntStream intS = IntStream.of(1, 3, 5, 8);
        DoubleStream doubleS = DoubleStream.of(1, 3, 5, 8);
        LongStream longS = LongStream.of(1, 3, 5, 8);

        // Si queremos volver a pasar de primitivos a Objects tenemos el método boxed()
        Stream<Integer> boxedInts = intS.boxed();

        // Al igual que para un Stream básico tenemos los métodos mapToDouble(), mapToInt()... que devuelven un stream
        // primitivo, también, al revés, para Streams primitivos tenemos el método mapToObj() que toma un primitivo y
        // devuelve un Object.
        Stream<Double> doubleStream = doubleS.mapToObj(val -> val);
    }
}
