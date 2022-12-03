package f01_Lambda_and_functional_interface.f02_functional_interfaces;

// Las Functional Interface son necesarias para escribir lambdas
// Una functional interface solo puede tener un método abstracto.
// NO es obligatorio indicar la anotación, pero al hacerlo, hacemos clara nuestra intención,
// y si escribimos más de un método nos indica un error.
@FunctionalInterface
public interface MyFunInterface {
    public void myMethod();
}
