package com.jmmunoz.gn03_subclassing;

import com.jmmunoz.gn03_subclassing.tipo_02.BaseData;
import com.jmmunoz.gn03_subclassing.tipo_02.Data;

// Hemos visto que un tipo genérico puede ser una clase genérica o una interface genérica.
// Vamos a ver ahora las subclases, es decir, como extenderlas. Los casos son>
//  1. Una interface genérica puede extender otras interfaces genéricas que tenga el mismo tipo parametrizado.
//      Ver paquete tipo_01
//  2. Una clase genérica puede extender otra clase genérica que tenga el mismo tipo parametrizado.
//      Ver paquete tipo_02
//  3. Una interface genérica puede ser implementada por una clase no genérica solo si definimos la clase como
//      un tipo parametrizado, como Integer, una interface, otra clase...
//      Ver paquete tipo_03
//  4. Una clase genérica puede extender un tipo no genérico (tipo, clase, interface)
//      Ver paquete tipo_04
//  4. Si tenemos dos clases genéricas y ambas extienden la misma interface genérica, y supongamos que una clase
//      a su vez extiende a la otra clase, si cambio en la interface del genérico a un tipo parametrizado, es decir,
//      cambio la T por Integer por ejemplo, obtendremos un error.
//      Ver paquete tipo_05
public class Subclassing {

    public static void main(String[] args) {

        // Importante: Tienen que tener el mismo tipo parametrizado
        Data<String> d1 = new Data<>("Data 1");
        BaseData<String> b1 = d1;
    }
}
