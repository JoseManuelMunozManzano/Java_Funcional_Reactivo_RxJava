package f08_streams_and_parallel_streams.f04_streams_are_not_data_containers;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleUse {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        // No se puede generar el stream y luego recorrerlo 2 veces como en este ejemplo porque una vez que se
        // recorre un stream este queda vacío.
        // Un stream es inmutable y solo se puede usar una vez.
        // No se puede añadir/eliminar nada a un stream existente. Únicamente se puede leer el stream una vez, operar
        // sobre sus elementos y devolver un nuevo stream.
        // Por eso un stream es como un Iterador, pero no como una Colección que almacena datos.
        // Además, en contraste con las colecciones que se iteran de forma explícita con un iterador, las operaciones
        // en un stream realizan la iteración automáticamente
        Stream<Book> stream = books.stream();

        List<Book> popularHorrorBooks = stream
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());

        // Aquí el stream está vacío, ya se ha usado en el stream pipeline anterior
        // Hay que volver a cargar con books.stream()
        List<Book> popularRomanticBooks = stream
                .filter(book -> book.getGenre().equalsIgnoreCase("Romance"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());

        popularHorrorBooks.forEach(System.out::println);
        popularRomanticBooks.forEach(System.out::println);
    }
}
