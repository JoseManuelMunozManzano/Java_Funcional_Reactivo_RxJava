package com.jmmunoz.gn06_multiple_type_parameters;

public class Bin<D, W> {

    private D dryTrash;
    private W wetTrash;

    public D getDryTrash() {
        return dryTrash;
    }

    public void setDryTrash(D dryTrash) {
        this.dryTrash = dryTrash;
    }

    public W getWetTrash() {
        return wetTrash;
    }

    public void setWetTrash(W wetTrash) {
        this.wetTrash = wetTrash;
    }
}
