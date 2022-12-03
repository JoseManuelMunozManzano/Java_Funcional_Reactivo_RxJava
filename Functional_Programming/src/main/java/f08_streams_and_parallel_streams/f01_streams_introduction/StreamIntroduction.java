package f08_streams_and_parallel_streams.f01_streams_introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroduction {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Book> popularHorrorBooks = new ArrayList<>();

        // Filtrar sin usar streams, antes de Java 8, de forma imperativa
        for (Book book: books) {
            if (book.getGenre().equalsIgnoreCase("Horror") && book.getRating() > 3) {
                popularHorrorBooks.add(book);
            }
        }

        // En SQL sería
        // SELECT name FROM books WHERE genre = 'horror' AND rating > 3

        // Con streams se pueden procesar los datos parecido a SQL, de forma>
        //      Declarativa
        //      Flexible
        //      Paralelizable usando el método stream().parallel() o directamente parallelStream()
        //
        // Cómo funcionan los streams?
        //  1. El stream toma los datos de una fuente
        //  2. Realiza el procesamiento
        //  3. Devuelve la data al contenedor que quiere el usuario o se consume la data
        List<Book> pHorrorBooks = books.stream().parallel()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());

        // Con esto podemos definir un Stream como una secuencia de elementos provenientes de una fuente que soporta
        // operaciones de procesamiento de datos y al final los datos los consumimos o los
        // recogemos en un contenedor distinto.
    }
}
