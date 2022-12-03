package f08_streams_and_parallel_streams.f13_stream_of_and_flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation {

    public static void main(String[] args) {
        // Dados estos dos streams
        Stream<String> a = Stream.of("Hello ", "there!");
        Stream<String> b = Stream.of("Adriana ", "José Manuel");

        // Intentamos invocar el método of() sobre ellos y vemos que el resultado es un Stream de Streams de String.
        Stream<Stream<String>> c = Stream.of(a, b);

        // Cómo podríamos obtener un Stream de String con todos los elementos de los dos streams?
        // Hay que aplanar los streams individuales en un stream.
        // Para eso tenemos el método flatMap()
        // Se le pasa un mapper que en este caso es un identity function, es decir, toma un elemento y lo devuelve.
        Stream<String> stream = Stream.of(a, b)
                .flatMap(e -> e);

        // Ejemplo en el que se lee un fichero de texto y pasamos a stream todas las palabras presentes en el fichero
        // para poder realizar operaciones sobre esas palabras.
        Path p = Paths.get("src/main/resources/Git - Comandos");
        try (Stream<String> lines = Files.lines(p)) {
            List<String> collect = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
