package f11_creating_your_own_collectors.f01_how_collectors_works_internally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

// stream.collects(collector);
// collect() toma un collector como argumento.
// El collector es un interface que se construye de la siguiente forma:
// Tiene 5 métodos abstractos, todos higher order functions salvo el método characteristics()
// supplier()
// accumulator()
// combiner()
// finisher()
// characteristics()
// No tenemos que implementarlos porque ya los tenemos en la clase Collectors.
// static class CollectorImpl<T, A, R> implements Collector<T, A, R>
// El constructor es el siguiente:
// return new CollectorImpl<>(supplier, accumulator, finisher, combiner, characteristics);
// Y ahora para llamarlos el orden sería:
// container = collector.supplier().get();
// BiConsumer accumulator = collector.accumulator();
// forEach(u -> accumulator.accept(container, u));
// //combining Step if parallel
// return collector.finisher().apply(container);
public class CustomCollector {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);

        // Construyendo el collector
        // El characteristic IDENTITY_FINISH indica que no hay necesidad de tener o ejecutar la función finisher()
        // porque es la función identidad, es decir, lo que se pasa es lo que se obtiene.
        // Es la más común
        Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(
                ArrayList::new,                                 // supplier
                (list, e) -> list.add(e),                       // accumulator (BiConsumer)
                (list1, list2) -> {                             // consumer (BiFunction)
                    list1.addAll(list2);
                    return list1;
                },
                Collector.Characteristics.IDENTITY_FINISH       // characteristics
        );

        List<Integer> evens = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect((toList));

        evens.forEach(System.out::println);

        System.out.println("\n--------------\n");

        // Construcción de collector que suma elementos en la lista de forma ordenada
        Collector<Integer, List<Integer>, List<Integer>> toSortedListCollector = Collector.of(
                ArrayList::new,                                 // supplier
                (list, e) -> list.add(e),                       // accumulator (BiConsumer)
                (list1, list2) -> {                             // consumer (BiFunction)
                    list1.addAll(list2);
                    return list1;
                },
                (list) -> {                                     // finisher
                    Collections.sort(list);
                    return list;
                },
                Collector.Characteristics.UNORDERED             // characteristics
        );

        List<Integer> sortedList = numbers.stream()
                .collect(toSortedListCollector);

        sortedList.forEach(System.out::println);
    }
}
