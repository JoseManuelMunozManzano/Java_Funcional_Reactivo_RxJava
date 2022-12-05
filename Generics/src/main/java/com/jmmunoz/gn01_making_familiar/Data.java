package com.jmmunoz.gn01_making_familiar;

// Solo admite String
public class Data {

    private String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data is: " + data;
    }
}
