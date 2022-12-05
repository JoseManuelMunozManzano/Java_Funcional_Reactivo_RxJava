package com.jmmunoz.dp05_factory_design_pattern.factory;

// Factory Design Pattern
// Usa una clase para crear los objetos
public class FactoryDesignPattern {

    public static void main(String[] args) {
        Database db = null;

        db = DatabaseFactory.getDatabase("RDBMS");
        System.out.println("Database: " + db.getClass().getSimpleName());
        System.out.println(db.connect());

        db = DatabaseFactory.getDatabase("DBMS");
        System.out.println("Database: " + db.getClass().getSimpleName());
        System.out.println(db.connect());
    }
}
