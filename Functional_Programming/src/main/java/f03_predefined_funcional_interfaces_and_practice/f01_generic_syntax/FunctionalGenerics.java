package f03_predefined_funcional_interfaces_and_practice.f01_generic_syntax;

@FunctionalInterface
public interface FunctionalGenerics<T, R> {

    R execute(T t);
}
