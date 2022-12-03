package f09_creating_streams_from_custom_source_spliterator.f03_custom_spliterator;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomSpliterator {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/Books.txt");
        // Esto devuelve un stream con todas las líneas presentes en el fichero
        // Pero no queremos eso
        // Vamos a crear un Spliterator que construya un stream de objetos Book.
        // En vez de leer línea a línea, tenemos que leer objeto a objeto.
        try(Stream<String> lines = Files.lines(path)) {
            Spliterator<String> baseSpliterator = lines.spliterator();
            Spliterator<Book> spliterator = new BookSpliterator(baseSpliterator);

            // Para usar el spliterator generado usamos el método StreamSupport.stream()
            Stream<Book> stream = StreamSupport.stream(spliterator, false);
            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
