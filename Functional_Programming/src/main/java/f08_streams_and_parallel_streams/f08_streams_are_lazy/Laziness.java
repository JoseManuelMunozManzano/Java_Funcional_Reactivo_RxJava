package f08_streams_and_parallel_streams.f08_streams_are_lazy;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Laziness {

    public static void main(String[] args) {
        // Todas las operaciones intermedias realizadas sobre los streams se dice que son perezosas (lazy) y
        // la operación final se dice que es impaciente (eager)
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        // Este stream pipeline en el que solo hay operaciones intermedias no se ejecuta realmente en este momento
        Stream<Book> stream = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .peek(book -> System.out.println("Filtered book " + book))
                .filter(book -> book.getRating() > 3);

        System.out.println("Filtering Done!");

        collect(stream);
    }

    private static void collect(Stream<Book> stream) {
        // Es en este momento, cuando se aplica la operación final, que se ejecuta el stream pipeline.
        List<Book> popularHorrorBooks = stream.toList();

        System.out.println("Collection Done!");

        popularHorrorBooks.forEach(System.out::println);
    }
}
