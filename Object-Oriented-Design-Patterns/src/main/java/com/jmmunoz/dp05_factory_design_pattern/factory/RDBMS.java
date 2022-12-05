package com.jmmunoz.dp05_factory_design_pattern.factory;

public class RDBMS implements Database {

    @Override
    public String connect() {
        return "Connection Successfull to RDBMS";
    }
}
