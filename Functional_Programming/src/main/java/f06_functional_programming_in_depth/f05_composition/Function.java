package f06_functional_programming_in_depth.f05_composition;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<V, R> compose(Function<V, T> before) {

        return (V v) -> apply(before.apply(v));
    }
}
