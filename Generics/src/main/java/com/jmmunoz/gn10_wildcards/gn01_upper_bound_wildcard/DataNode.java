package com.jmmunoz.gn10_wildcards.gn01_upper_bound_wildcard;

public class DataNode<E> {

    private E data;
    private DataNode<E> next;

    public DataNode(E data, DataNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DataNode<E> getNext() {
        return next;
    }

    public void setNext(DataNode<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DataNode [data = " + data + ", next = " + next + "]";
    }
}
