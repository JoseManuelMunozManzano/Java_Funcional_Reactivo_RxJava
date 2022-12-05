package com.jmmunoz.dp05_factory_design_pattern.factory_method;

public class FactoryMethodDesignPattern {

    public static void main(String[] args) {
        DB db1  = DB.getRDBMS();
        System.out.println(db1);

        DB db2  = DB.getDBMS();
        System.out.println(db2);

    }
}
