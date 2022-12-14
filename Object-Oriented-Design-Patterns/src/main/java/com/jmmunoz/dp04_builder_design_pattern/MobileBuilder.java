package com.jmmunoz.dp04_builder_design_pattern;

public abstract class MobileBuilder {

    Mobile mobile;

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public abstract void createMemory();

    public abstract void createBattery();

    public abstract void createWireless();

    public abstract void createScreen();

    public abstract void createMetalCase();

    public final Mobile buildMobile() {
        Mobile mob = new Mobile();

        setMobile(mob);

        createMemory();
        createBattery();
        createWireless();
        createScreen();
        createMetalCase();

        return mob;
    }
}
