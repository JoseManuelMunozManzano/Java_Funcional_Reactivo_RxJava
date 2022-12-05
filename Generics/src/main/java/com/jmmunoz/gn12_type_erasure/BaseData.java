package com.jmmunoz.gn12_type_erasure;

// Durante Type Erasure, el compilador reemplaza la T por Object, ya que no está acotado.
// En cualquier sitio donde sea necesario hacer un cast, el compilador lo hará.
public class BaseData<T> {

    private T data;

    public BaseData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data is: " + data;
    }
}
