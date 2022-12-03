package f08_streams_and_parallel_streams.f03_stream_pipeline;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPipeline {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        // A esta construcción se le llama Stream Pipeline.
        // Consiste en:
        //  1. Fuente
        //  2. Cero o más operaciones intermedias
        //  3. Una operación final (un resultado o un efecto colateral)
        List<Book> popularHorrorBooks = books.stream()      // Source
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))     // Intermediate Op
                .filter(book -> book.getRating() > 3)       // Intermediate Op
                .collect(Collectors.toList());      // Terminal Op
    }
}
