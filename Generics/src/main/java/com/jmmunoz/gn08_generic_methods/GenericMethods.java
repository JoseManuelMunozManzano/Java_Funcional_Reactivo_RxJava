package com.jmmunoz.gn08_generic_methods;

// Imaginemos que no necesitamos parametrizar toda la clase.
// Es posible generalizar solo aquellos métodos que necesitamos que sean genéricos.
// Como los constructores son una clase especial de método, también se puede generalizar.
public class GenericMethods {

    public static void main(String[] args) {
        System.out.println(concat("Hola que tal"));
        System.out.println(concat("21"));
    }

    // Hacemos solo este método genérico.
    // Como la clase no es genérica, para que esto funcione tenemos que indicar, antes del tipo de retorno,
    // el tipo parametrizado
    public static <T> String concat(T data) {
        return "Data is: " + data;
    }
}
