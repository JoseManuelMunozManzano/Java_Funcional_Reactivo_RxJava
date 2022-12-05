package com.jmmunoz.gn10_wildcards.gn01_upper_bound_wildcard;

public class DataNodeWildcard<E> {

    private E data;
    // Upper Bounded Wildcard. El node next puede ser Number o cualquiera de sus subtipos.
    // Se especifica: ? extends A
    // Donde A es el upper bound. Puede ser una clase, interface o tipo de datos.
    // Asi limitamos.
    private DataNodeWildcard<? extends Number> next;

    public DataNodeWildcard(E data, DataNodeWildcard<? extends Number> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DataNodeWildcard<? extends Number> getNext() {
        return next;
    }

    public void setNext(DataNodeWildcard<? extends Number> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DataNode [data = " + data + ", next = " + next + "]";
    }
}
