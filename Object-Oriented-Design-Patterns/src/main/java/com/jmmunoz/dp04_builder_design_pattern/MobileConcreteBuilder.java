package com.jmmunoz.dp04_builder_design_pattern;

public class MobileConcreteBuilder extends MobileBuilder {

    @Override
    public void createMemory() {
        getMobile().setMemory("32 GB");
        System.out.println("Memory created and installed");
    }

    @Override
    public void createBattery() {
        getMobile().setBattery("4500 mAh");
        System.out.println("Battery created and installed");
    }

    @Override
    public void createWireless() {
        getMobile().setWireless("Bluetooth and WiFi");
        System.out.println("Created Wireless features and installed");
    }

    @Override
    public void createScreen() {
        getMobile().setScreen("Amoled");
        System.out.println("Screen created and installed");
    }

    @Override
    public void createMetalCase() {
        getMobile().setMetalCase("Aluminium");
        System.out.println("Metal case created and pluged everything in it.");
    }
}
