package com.jmmunoz.dp05_factory_design_pattern.factory_method;

// Ejemplo con Factory Method Pattern
// La diferencia con Factory es que en Factory Method solo tenemos métodos que actúan como factory para crear
// objetos, mientras que en Factory tenemos una clase.
public class DB {

    private String properties;

    private static final String P1 = "RDBMS Properties";
    private static final String P2 = "DBMS Properties";

    private DB(String type) {
        this.properties = type;
    }

    public static DB getRDBMS() {
        return new DB(P1);
    }

    public static DB getDBMS() {
        return new DB(P2);
    }

    @Override
    public String toString() {
        return properties;
    }
}
