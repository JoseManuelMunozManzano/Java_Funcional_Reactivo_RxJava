package com.jmmunoz.gn08_generic_methods;

import java.util.List;

public class Box {

    private List a;

    // Ejemplo de constructor genérico incluso aunque la clase no es genérica.
    // No olvidar indicar el tipo parametrizado antes del nombre del constructor.
    public <T> Box(List<T> a) {
        this.a = a;
    }

    public List getA() {
        return a;
    }

    public void setA(List a) {
        this.a = a;
    }
}
