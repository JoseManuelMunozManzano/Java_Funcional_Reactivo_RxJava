package com.jmmunoz.gn02_generic_type_interfaces;

// Ya hemos visto en gn01 como se trabaja con clases genéricas y ahora vamos a ver como trabajar con interfaces
// genéricas.
//
// JDK implementa generic interfaces en:
//  Comparable<T>
public class GenericInterfaces {

    public static void main(String[] args) {

        IData<String> d1 = new Data<>("We have implemented a Generic Interface");

        System.out.println(d1);
    }
}
