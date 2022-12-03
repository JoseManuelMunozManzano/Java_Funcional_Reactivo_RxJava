package f06_functional_programming_in_depth.f07_currying;

import f06_functional_programming_in_depth.f05_composition.Function;

// Currying es una técnica que modifica una función multiparámetro en muchas funciones de un solo parámetro
// cada una.
public class Currying {

    public static void main(String[] args) {

        // Para modificar a muchas funciones de un solo parámetro, lo que hay que hacer es ir devolviendo funciones
        Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;

        Function<Integer, Integer> fun2 = fun1.apply(1);

        Integer sum = fun2.apply(6);
        System.out.println(sum);

        // Otra forma donde se devuelve fun2 y se aplica la otra parte de la suma
        sum = fun1.apply(1).apply(10);
        System.out.println(sum);

        // Se puede tener un valor calculado (fun1) y luego jugar con el otro valor
        // Con funciones multiparámetro habría que pasar siempre el valor 2.
        Integer sum1 = fun2.apply(2);

        Integer sum2 = fun2.apply(3);
        Integer sum3 = fun2.apply(6);

        System.out.println(sum2);

        // Otra ventaja de Currying es que permite reutilizar interfaces existentes como Function<> para expresar
        // funciones con múltiples argumentos. En el ejemplo anterior se ha conseguido pasar dos argumentos.
        // Y en este ejemplo se pueden usar 3 argumentos.
        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun3 = u -> v -> w -> u + v + w;

        Function<Integer, Function<Integer, Integer>> fun4 = fun3.apply(1);

        Function<Integer, Integer> fun5 = fun4.apply(2);

        Integer sum4 = fun5.apply(3);
        System.out.println(sum4);

        // O de la "forma corta"
        System.out.println(fun3.apply(5).apply(3).apply(2));
    }
}
