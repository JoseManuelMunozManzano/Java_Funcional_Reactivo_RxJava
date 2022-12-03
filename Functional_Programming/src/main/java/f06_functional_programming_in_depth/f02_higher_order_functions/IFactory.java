package f06_functional_programming_in_depth.f02_higher_order_functions;

// Produce el item y lo configura
public interface IFactory<T> {

    T create();
}
