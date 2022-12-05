package com.jmmunoz.gn10_wildcards;

import java.util.ArrayList;
import java.util.List;

// Vamos a hablar del carácter comodín, ?
// Representa tipo desconocido y puede usarse como tipo de parámetro, campo, variable local o a veces como tipo
// de return.
public class Wildcards {

    // Usando wildcard (Unbounded Wildcard)
    // Esto hace que NO sea un método generic, por lo que no indicamos el tipo parametrizado antes del tipo devuelto.
    // IMPORTANTE: NO se puede usar wildcard escribiendo ? directamente.
    //      En este caso está en una List, indicando que no sabemos que tipos de elementos contiene la lista.
    // Tampoco se puede usar como tipo de return, es decir, esto no es posible: public static ? displayData()
    public static void displayData(List<?> l) {
        // Indicamos Object
        for (Object t : l) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {

        // Este código funciona exactamente igual usando el método un wildcard o usando un tipo parametrizado.
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(57);

        // Cuál es la diferencia entre utilizar un wildcard o utilizar un tipo parametrizado?
        // Se puede usar wildcard en muchos sitios donde puede, no puede, usarse un tipo parametrizado:
        // - Al crear el objeto
        //      Un tipo parametrizado se usa en clases genéricas, métodos genéricos y constructores genéricos,
        //      pero no creamos una lista con T, en plan: List<T> list = new ArrayList<>()
        //      Sin embargo, si se puede usar el wildcard al crear un objeto.
        List<?> list2 = new ArrayList<>();
    }
}
