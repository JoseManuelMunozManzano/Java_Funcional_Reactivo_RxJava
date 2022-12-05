package com.jmmunoz.gn07_subtyping;

import com.jmmunoz.gn05_raw_type.Box;

import java.util.ArrayList;
import java.util.List;

public class Subtyping {

    public static void main(String[] args) {

        // Ejemplo de Sub-typing
        // Integer es una subclase de la clase Object y son compatibles, por lo que esta asignación es correcta.
        Object o = new Object();
        Integer i = Integer.valueOf(11);
        o = i;

        // Lo mismo es posible con Generics
        // Tanto Integer como Double son subclases de la clase Number.
        List<Number> list = new ArrayList<>();
        list.add(Integer.valueOf(10));
        list.add(Double.valueOf(10));
        // Error. String no es subclase de la clase Number.
        //list.add("Hello");

        // Con clases creadas por nosotros
        // SquareBox es una subclase de Box y por eso es permitido, porque son clases compatibles.
        List<Box<Integer>>  bList = new ArrayList<>();
        bList.add(new Box(List.of(1, 2, 3)));
        bList.add(new SquareBox<>(List.of(3, 7, 9, 10)));



        // Esto da error
        //List<Number> l1 = new ArrayList<Integer>();

        // Esto funciona
        List<Integer> l2 = new ArrayList<Integer>();

        // Entonces... Generic soporta subtyping?
        // Mientras no se varíe el tipo de argumento, el parentesco de subtyping se preserva entre los tipos.
        // Es necesario que ambos tipos de argumento sean el mismo.

        // Pero si queremos añadir el subtipo del elemento a una lista o a un objeto parametrizado con el supertipo,
        // se puede hacer.
    }
}
