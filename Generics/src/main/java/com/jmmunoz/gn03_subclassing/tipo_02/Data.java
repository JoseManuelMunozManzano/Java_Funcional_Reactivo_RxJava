package com.jmmunoz.gn03_subclassing.tipo_02;

import com.jmmunoz.gn02_generic_type_interfaces.IData;

public class Data<T> extends BaseData<T> implements IData<T> {

    // T es un tipo parametrizado
    private T data;

    public Data(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data is: " + data;
    }
}
