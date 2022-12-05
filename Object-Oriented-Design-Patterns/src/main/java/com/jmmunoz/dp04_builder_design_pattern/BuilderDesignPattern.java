package com.jmmunoz.dp04_builder_design_pattern;

// Es un patrón de diseño creacional.
// Builder provee una solución flexible a varios problemas de creación de objetos complejos en POO.
// El propósito del patrón Builder es aislar la construcción de objetos completos de su representación.
//
// Cuando usar el patrón Builder:
//  - Cuando el algoritmo para crear un objeto complejo debe ser independiente de las partes que componen
//      el objeto y de como se ensambla.
//  - Cuando el proceso de construcción debe permitir diferentes representaciones para el objeto que se está
//      construyendo.
//
// JDK implementa el patrón Builder en:
//  java.lang.StringBuilder#append() (unsynchronized)
//  java.lang.StringBuffer#append()  (synchronized)
//  javax.swing.GroupLayout.Group#addComponent()
//  Todas las implementaciones de java.lang.Appendable
public class BuilderDesignPattern {

    public static void main(String[] args) {

        Mobile m = Manufacturer.createCompleteObject();
        System.out.println(m);
    }
}
