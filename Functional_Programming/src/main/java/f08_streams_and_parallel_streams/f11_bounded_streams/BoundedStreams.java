package f08_streams_and_parallel_streams.f11_bounded_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoundedStreams {

    public static void main(String[] args) {
        // Creación de Streams finitos (bounded streams)

        // 1. Se pueden crear streams a partir de colecciones
        List<Integer> list = List.of(1, 4, 7, 9, 4);
        Stream<Integer> streamIntegers = list.stream();

        // 2. Pero si tenemos un map, no hay manera directa de ponerlo en un stream porque map tiene un par clave-valor,
        // cosa que no tienen las listas ni otras colecciones que tienen datos dispuestos linealmente.
        // Por eso no existe el método stream() sobre un map.
        // Pero si se puede pasar a stream los entries, keys o values de un map.
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five");

        Stream<Map.Entry<Integer, String>> entries = map.entrySet().stream();
        Stream<String> values = map.values().stream();
        Stream<Integer> keys = map.keySet().stream();

        // 3. of() es un método que sirve para generar streams con los valores deseados
        Stream<String> streamStrings = Stream.of("Hey!", "Happy", "Thanksgiving");

        // 4. Se pueden crear streams de arrays usando la clase Arrays
        //      Si es el objetoString
        Integer[] integerArr = {3, 5, 7, 89, 9};
        Stream<Integer> stream = Arrays.stream(integerArr);

        //      Si es la primitiva int
        int[] intArr = {3, 5, 7, 89, 9};
        IntStream stream1 = Arrays.stream(intArr);

        // 4. Construir un Builder y añadir elementos. Para construir el stream invocamos el método build() del Builder.
        // Este enfoque es más flexible que usar el método of()
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        //          suponemos que hay aquí código en medio
        //          condiciones para añadir (o no) elementos al builder
        builder.add(4);

        builder.build();
    }
}
