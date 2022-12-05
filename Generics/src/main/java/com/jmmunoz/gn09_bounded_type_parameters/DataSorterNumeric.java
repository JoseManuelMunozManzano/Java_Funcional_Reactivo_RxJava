package com.jmmunoz.gn09_bounded_type_parameters;

import java.util.List;

// Restringiendo el generic para que solo permite numéricos o cualquiera de sus subclases.
public class DataSorterNumeric<T extends Number> {

    private List<T> list;

    public DataSorterNumeric(List<T> list) {
        this.list = list;
    }

    public void getSortedData() {
        list.sort(null);;

        for (T t : list ) {
            System.out.println(t);
        }
    }
}
