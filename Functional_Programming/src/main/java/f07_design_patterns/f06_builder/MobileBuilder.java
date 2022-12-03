package f07_design_patterns.f06_builder;

import f06_functional_programming_in_depth.f04_chaining.Consumer;

public class MobileBuilder {

    int ram, storage;
    int battery;
    int camera;
    String processor;
    double screenSize;

    public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
        buildFields.accept(this);
        return this;
    }

    public Mobile createMobile() {
        return new Mobile(this);
    }
}
