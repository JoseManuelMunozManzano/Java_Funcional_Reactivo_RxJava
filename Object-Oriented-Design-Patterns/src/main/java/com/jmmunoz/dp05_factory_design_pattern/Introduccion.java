package com.jmmunoz.dp05_factory_design_pattern;

// Factory es un patrón creacional.
// Factory encapsula la funcionalidad requerida para seleccionar e instanciar una clase apropiada dentro de un
// método designado al que se le llama Factory Method.
//
// Cuando usar el patrón Factory:
//  - Cuando una clase no puede anticipar los objetos que debe crear.
//  - Cuando una clase quiere que sus subclases especifiquen los objetos que crea.
//  - Cuando las clases delegan responsabilidad a una o varias subclases helper, y queremos localizar el conocimiento
//      de que subclase helper es la delegada.
//
// JDK usa Factory Method en:
//  java.util.Calendar#getInstance()
//  java.util.ResourceBundle#getBundle()
//  java.text.NumberFormat#getInstance()
//  java.nio.charset.Charset#forName()
public class Introduccion {
}
