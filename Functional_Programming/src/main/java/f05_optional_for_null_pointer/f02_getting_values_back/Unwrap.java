package f05_optional_for_null_pointer.f02_getting_values_back;

import java.util.Optional;

public class Unwrap {

    public static void main(String[] args) {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a);

        // Para recuperar el valor se usa el método get()
        // Pero NO debe usarse a no ser que estemos 100% seguros que tenemos un valor.
        Integer integerVal = optional.get();
        System.out.println(integerVal);

        // Peligro del método get()
        // Obtenemos como resultado la excepción NoSuchElementException y toda la idea de Optional se vuelve inútil.
        Optional<Integer> emptyOptional = Optional.empty();
        //System.out.println(emptyOptional.get());

        // Se puede usar el método isPresent() que devuelve un booleano para indicar si hay valor o null.
        // Pero volvemos a hacer un if. Hay mejores alternativas
        // También existe isEmpty
        Integer val = optional.isPresent() ? optional.get() : 0;
        System.out.println(val);

        Integer val2 = emptyOptional.isPresent() ? emptyOptional.get() : 0;
        System.out.println(val2);

        // orElse, orElseGet
        // Se usa orElse para establecer un valor por defecto que se devuelve si la variable es null
        Integer orElse = optional.orElse(0);
        System.out.println(orElse);

        Integer orElse2 = emptyOptional.orElse(0);
        System.out.println(orElse2);

        // Se usa orElseGet para establecer un valor por defecto usando un Supplier
        Integer orElseGet = emptyOptional.orElseGet(() -> 0);
        System.out.println(orElseGet);

        // En cuanto a rendimiento, la diferencia entre orElse y orElseGet es que en el primer caso el objeto
        // que contiene el valor por defecto se genera SIEMPRE y en el segundo caso solo se genera el objeto
        // cuando es empty. Si no lo es no se ejecuta la función Supplier.

        // orElseThrow sirve para cuando la variable es null y queremos que nos devuelva una excepción concreta,
        // usando una función Supplier. Por supuesto, si la variable contiene un valor lo devuelve.
        emptyOptional.orElseThrow(() -> new IllegalArgumentException());

        // En Java 10 hay un nuevo orElseThrow sin argumentos. Si la variable contiene valor lo devuelve y si es null
        // lanza la excepción NoSuchElementException, como hace la función get(), pero su nombre es más claro.
    }
}
