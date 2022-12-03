package f09_creating_streams_from_custom_source_spliterator.f02_spliterator_characteristics;

// Characteristics of a stream
// Se usan para definir el estado del Stream
//
// public static final int ORDERED    = 0X00000010;
// public static final int DISTINCT   = 0X00000001;
// public static final int SORTED     = 0X00000001;
// public static final int SIZED      = 0X00000040;
// public static final int NONNULL    = 0X00000100;
// public static final int IMMUTABLE  = 0X00000400;
// public static final int CONCURRENT = 0X00001000;
// public static final int SUBSIZED   = 0X00004000;

// ORDERED --> Para el stream generado en el Spliterator, el orden importa
// DISTINCT --> Indica que no hay duplicidad en el Spliterator
// SORTED --> El stream está ordenado
// SIZED --> Indica que el tamaño del Spliterator es conocido
// NONNULL --> No puede haber valores null presentes en el stream
// IMMUTABLE --> El stream es inmutable
// CONCURRENT --> El stream se ha construido sobre una estructura concurrente.
// SUBSIZED --> Su tamaño es conocido y además todos los Spliterators resultado del método trySplit() serán SIZED

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SpliteratorCharacteristics {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(0);
        list.add(1);

        Stream<Integer> stream = list.stream();
        Spliterator<Integer> spliterator = stream.spliterator();

        // Obtenemos las características. El resultado es 3, que indica 3 características.
        // Son, yendo a la clase de ArrayList y buscando characteristics: ORDERED, SIZED y SUBSIZED
        int bits = spliterator.characteristics();
        System.out.println(Integer.bitCount(bits));

        // Bitwise OR
        // Sigue saliendo 3 porque el hexadecimal 0X00000010 está incluido en bits
        System.out.println(Integer.bitCount(bits | 0X00000010));

        // Bitwise AND
        // Obtengo 0X00000010, que es 16
        System.out.println(bits & 0X00000010);

        // Pero lo mejor es usar el método hasCharacteristics()
        System.out.println(spliterator.hasCharacteristics(0X00000010));

        // Como estas characteristics o estado de stream ayudan en la optimización de rendimiento.
        // Si tenemos este pipeline:
        SortedSet<Integer> set = new TreeSet<>();
        set.stream().sorted().forEach(System.out::println);
        // Y en las characteristicas hemos indicado SORTED, entonces el paso intermedio del pipeline .sorted()
        // no lo va a hacer.
    }
}
