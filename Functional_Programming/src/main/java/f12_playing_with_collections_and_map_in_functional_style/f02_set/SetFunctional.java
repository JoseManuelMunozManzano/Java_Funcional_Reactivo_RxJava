package f12_playing_with_collections_and_map_in_functional_style.f02_set;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

// Vamos a ver:
// - Traversing
// - Filtering
// - Sorting
// - Mapping
// - Reducing
public class SetFunctional {

    public static void main(String[] args) {
        Set<Integer> set = Set.of(3, 56, 7, 82, 39);

        // Traversing
        set.forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Filtering
        set.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Sorting
        set.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Si queremos devolver los datos en un set tiene que ser un TreeSet, que preserva el orden.
        TreeSet<Integer> sortedSet = set.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        sortedSet.forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Mapping
        Set<Double> hashSet = set.stream()
                .map(e -> Double.valueOf(e))
                .collect(Collectors.toSet());

        hashSet.forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Reducing
        int sum = set.stream()
                .mapToInt(e -> e)
                .sum();

        System.out.println(sum);
    }
}
