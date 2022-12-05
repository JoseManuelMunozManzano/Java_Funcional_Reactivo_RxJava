package com.jmmunoz.gn03_subclassing.tipo_05;

// Error en Iinterface<Integer>
// Debe ser Iinterface<T>
// El compilador nos indica el error
// public class Class1<T> extends Class2<T>  implements Iinterface<Integer>

public class Class1<T> extends Class2<T>  implements Iinterface<T> {
}
