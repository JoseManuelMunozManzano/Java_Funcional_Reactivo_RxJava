package f08_streams_and_parallel_streams.f02_observing_the_stream;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObservingStream {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        List<Book> popularHorrorBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());

        // Dividiendo el stream en pasos
        // 1. El stream toma los datos de una fuente
        Stream<Book> stream = books.stream();
        // 2. Realiza el procesamiento (va devolviendo streams)
        Stream<Book> horrorBooks = stream.filter(book -> book.getGenre().equalsIgnoreCase("Horror"));
        Stream<Book> pHorrorBooks = stream.filter(book -> book.getRating() > 3);
        // 3. Devuelve la data al contenedor que quiere el usuario o se consume la data
        List<Book> collect = pHorrorBooks.collect(Collectors.toList());
    }
}
