package com.jmmunoz.gn09_bounded_type_parameters;

import java.util.Arrays;
import java.util.List;

// Tipos parametrizados acotados
// Un tipo parametrizado puede ser de cualquier tipo referenciado, pero hay muchos casos en los que queremos
// acotar los tipos que se pueden usar como tipo de argumento en una clase genérica.
public class BoundedTypeParameters {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(new Integer[] {2, 5, 8, 9});
        List<String> sList = Arrays.asList(new String[] {"Hello", "there", "people"});

        // Tal y como está implementado, DataSorter permite cualquier tipo de dato parametrizado
        DataSorter<Integer> sorter1 = new DataSorter<>(list);
        DataSorter<String> sorter2 = new DataSorter<>(sList);

        sorter1.getSortedData();
        sorter2.getSortedData();


        // Si solo quiero permitir datos numéricos
        DataSorterNumeric<Integer> sorter3 = new DataSorterNumeric<>(list);
        // Esto ahora falla porque String no es un subtipo de Number.
        //DataSorterNumeric<String> sorter4 = new DataSorterNumeric<>(sList);

        // Sin embargo, el tipo Double funciona perfectamente
        List<Double> dList = Arrays.asList(new Double[] {2.5, 5.7, 8.9, 9.1});
        DataSorterNumeric<Double> sorter5 = new DataSorterNumeric<>(dList);
        sorter5.getSortedData();


        CBound b = new CBound();
        getSortedData(b);
    }

    // También podemos acotar el tipo parametrizado en un método genérico cuya clase no es genérica.
    // En este ejemplo estamos acotando T a la interface IBound
    // Otra cosa interesante al acotar el tipo parametrizado con interface, es que podemos acotar el tipo
    // parametrizado con más de una interface usando el signo &
    // Recordar que en este caso la clase debe implementar ambas interfaces.
    //
    // Lo que no se puede hacer porque Java no permite herencia múltiple es acotar el tipo parametrizado a más
    // de una clase.
    public static <T extends IBound1 & IBound2> void getSortedData(T list) {
    }
}
