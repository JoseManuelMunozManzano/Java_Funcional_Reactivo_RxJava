package com.jmmunoz.gn06_multiple_type_parameters;

import java.util.HashMap;

// Podemos tener una clase genérica con muchos tipos parametrizados
public class MultipleTypeParameters {

    public static void main(String[] args) {

        // Dos tipos parametrizados, Integer para las claves y String para los valores
        HashMap<Integer, String> map = new HashMap<>();

        // Clase propia
        Bin<String, Integer> bin = new Bin<>();

        bin.setDryTrash("Nasty");
        bin.setWetTrash(123);

        System.out.println("Dry Trash: " + bin.getDryTrash() + ", Wet Trash: " + bin.getWetTrash());
    }
}
