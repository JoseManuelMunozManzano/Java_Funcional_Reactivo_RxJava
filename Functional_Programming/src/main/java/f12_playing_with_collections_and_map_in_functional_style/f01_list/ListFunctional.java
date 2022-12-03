package f12_playing_with_collections_and_map_in_functional_style.f01_list;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Vamos a ver:
// - Traversing
// - Filtering
// - Sorting
// - Mapping
// - Reducing
public class ListFunctional {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Spotlight",2015,"Hollywood"),
                new Movie("Avengers: Infinity War",2018,"Hollywood"),
                new Movie("Inception",2010,"Hollywood"),
                new Movie("Forest Gump",1994,"Hollywood"),
                new Movie("3 Idiots",2009,"Bollywood"),
                new Movie("Beauty and the beast",2017,"Hollywood"),
                new Movie("Slumdog Millionaire",2008,"Bollywood")
        );

        // Traversing
        movies.forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Sorting
        // Implementamos comparator en el momento. En este caso ordenamos de forma descendente por releaseYear
        movies.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
        movies.forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Filtering
        movies.stream()
                .filter(movie -> movie.getIndustry().equalsIgnoreCase("Bollywood"))
                .forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Mapping
        movies.stream()
                .map(movie -> movie.getName())
                .forEach(System.out::println);

        System.out.println("\n-----------------\n");

        // Reducing
        Optional<String> movieString = movies.stream()
                .map(movie -> movie.getName())
                .reduce((m1, m2) -> m1 + " | " + m2);

        System.out.println(movieString);
    }
}
