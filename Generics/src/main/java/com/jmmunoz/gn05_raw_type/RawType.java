package com.jmmunoz.gn05_raw_type;

import java.util.List;

// Un raw type es el nombre de una clase o interface genérica que no tiene argumentos de tipo.
// Cuando en Java 5 se introdujeron los Generics, los tipos raw quedaron para mantener la compatibilidad con
// versiones antiguas de Java.
// Podemos seguir usándolas, pero si vamos a tener elementos de un único tipo en nuestra colección, sería mejor
// no usarlas, porque no son Type Safe, con lo que podría haber error en tiempo de ejecución, y al recuperar la data
// va a hacer falta hacer un cast.
public class RawType {

    public static void main(String[] args) {

        // Usando el tipo genérico
        Box<Integer> genBox = new Box<>(List.of(1, 2, 3));

        for (Integer i : genBox.getA()) {
            System.out.println(i);
        }

        // Usando el tipo raw
        // No restringe a un único tipo, pero da un warning.
        Box rawBox = new Box(List.of(1, 2, "Hola"));
    }
}
