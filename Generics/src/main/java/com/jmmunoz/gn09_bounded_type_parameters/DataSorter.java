package com.jmmunoz.gn09_bounded_type_parameters;

import java.util.List;

public class DataSorter<T> {

    private List<T> list;

    public DataSorter(List<T> list) {
        this.list = list;
    }

    public void getSortedData() {
        list.sort(null);;

        for (T t : list ) {
            System.out.println(t);
        }
    }
}
