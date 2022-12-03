package f06_functional_programming_in_depth.f04_chaining;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    // Un default method necesita implementación
    // Si no tuviera implementación, la interface Consumer no podría ser una Functional Interface
    // porque sólo puede haber un método abstracto.
    default Consumer<T> thenAccept(Consumer<T> next) {
        Objects.requireNonNull(next);

        return (T t) -> {
            this.accept(t);
            next.accept(t);
        };
    }
}
