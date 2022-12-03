package f07_design_patterns.f06_builder;

public class Mobile {

    final int ram, storage;
    final int battery;
    final int camera;
    final String processor;
    final double screenSize;

    // Gracias a MobileBuilder solo tenemos que pasar un parámetro
    public Mobile(MobileBuilder builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.battery = builder.battery;
        this.camera = builder.camera;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public int getBattery() {
        return battery;
    }

    public int getCamera() {
        return camera;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return String.format("Specifications- RAM: %d Storage: %d Battery: %d Camera: %dMP Processor: %s Display: %f",
                ram, storage, battery, camera, processor, screenSize);
    }
}
