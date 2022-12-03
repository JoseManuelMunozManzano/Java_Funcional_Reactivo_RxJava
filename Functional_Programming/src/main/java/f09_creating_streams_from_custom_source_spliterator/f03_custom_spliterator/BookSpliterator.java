package f09_creating_streams_from_custom_source_spliterator.f03_custom_spliterator;

import f08_streams_and_parallel_streams.f01_streams_introduction.Book;

import java.util.Spliterator;
import java.util.function.Consumer;

public class BookSpliterator implements Spliterator<Book> {

    // Estos son los campos de la clase Book
    private String name;
    private String author;
    private String genre;
    private double rating;
    private Spliterator<String> baseSpliterator;

    public BookSpliterator(Spliterator<String> baseSpliterator) {
        this.baseSpliterator = baseSpliterator;
    }

    // El Api Stream llama a este método automáticamente.
    // Puede decirse que es el método principal del Spliterator.
    @Override
    public boolean tryAdvance(Consumer<? super Book> action) {
        if (this.baseSpliterator.tryAdvance(name -> this.name = name) &&
        this.baseSpliterator.tryAdvance(author -> this.author = author) &&
        this.baseSpliterator.tryAdvance(genre -> this.genre = genre) &&
        this.baseSpliterator.tryAdvance(rating -> this.rating = Double.parseDouble(rating))) {

            // Con esto BookSpliterator leerá la data Book a Book
            action.accept(new Book(this.name, this.author, this.genre, this.rating));

            // Si se puede construir el objeto Book devolverá true
            return true;
        }

        return false;
    }

    // No es necesario implementarlo porque no queremos procesarlo en paralelo
    @Override
    public Spliterator<Book> trySplit() {
        return null;
    }

    // El tamaño del stream que se va a crear
    // El fichero Books.txt tiene 24 líneas y cada Book son 4 líneas, así que el tamaño será 6
    @Override
    public long estimateSize() {
        return baseSpliterator.estimateSize() / 4;
    }

    // Aquí solo devolvemos las characteristics de nuestro baseSpliterator
    @Override
    public int characteristics() {
        return baseSpliterator.characteristics();
    }
}
