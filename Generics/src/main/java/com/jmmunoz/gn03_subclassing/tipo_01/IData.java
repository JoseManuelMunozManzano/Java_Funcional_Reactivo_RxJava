package com.jmmunoz.gn03_subclassing.tipo_01;

public interface IData<T> extends IBase<T> {

    public T getData();

    public void setData(T data);
}
