package com.jmmunoz.dp05_factory_design_pattern.factory;

public class DatabaseFactory {

    public static Database getDatabase(String dbType) {
        Database dc = null;
        if ("RDBMS".equalsIgnoreCase(dbType))
            dc = new RDBMS();
        else
            dc = new DBMS();

        return dc;
    }
}
