package f08_streams_and_parallel_streams.f05_filter_operations;

import java.util.stream.Stream;

public class FilterOperation {

    public static void main(String[] args) {
        Stream.of(34, 678, 89, 4, 52, 31, 325, 6)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
