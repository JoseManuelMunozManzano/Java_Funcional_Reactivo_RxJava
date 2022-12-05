package com.jmmunoz.gn07_subtyping;

import com.jmmunoz.gn05_raw_type.Box;

import java.util.List;

// SquareBox es una subclase de la clase Box
public class SquareBox<T> extends Box<T> {

    public SquareBox(List<T> a) {
        super(a);
    }
}
