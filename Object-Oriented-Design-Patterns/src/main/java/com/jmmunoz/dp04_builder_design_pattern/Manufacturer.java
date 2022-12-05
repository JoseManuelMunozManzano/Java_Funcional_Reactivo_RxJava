package com.jmmunoz.dp04_builder_design_pattern;

// Director
public class Manufacturer {

    public static Mobile createCompleteObject() {

        MobileBuilder mobBuilder = new MobileConcreteBuilder();

        return mobBuilder.buildMobile();
    }
}
