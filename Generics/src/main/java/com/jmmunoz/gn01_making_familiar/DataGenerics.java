package com.jmmunoz.gn01_making_familiar;

// Usando Generics
// T puede ser cualquier cosa y lo usamos para crear instancias de un objeto.
// Pero NO podemos hacer esto si tenemos un método o campo es†áticos porque los tipos parametrizados genéricos
// tiene un ámbito de INSTANCIA de clase, y los métodos y campos estáticos pertenecen a la clase y a todas las
// instancias. Por tanto, si tenemos un método estático... qué tipo usamos? String? Integer?
public class DataGenerics<T> {

    // T es un tipo parametrizado
    private T data;

    public DataGenerics(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data is: " + data;
    }
}
