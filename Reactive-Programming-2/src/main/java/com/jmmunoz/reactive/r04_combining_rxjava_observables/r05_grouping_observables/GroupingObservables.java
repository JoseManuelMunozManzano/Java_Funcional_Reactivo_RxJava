package com.jmmunoz.reactive.r04_combining_rxjava_observables.r05_grouping_observables;

import com.jmmunoz.reactive.r03_rxjava_operators.r03_operators_in_action.Employee;
import io.reactivex.rxjava3.core.Observable;

// Agrupa emisiones por alguna clave en Observables separados
// Tenemos:
//   sourceObs.groupBy(keySelector);
public class GroupingObservables {

    public static void main(String[] args) {

        Observable<Employee> obs = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Dhwanit", 94000, 4.7),
                new Employee(236, "Mike", 65000, 4.0),
                new Employee(155, "Ella", 85000, 4.4),
                new Employee(443, "George", 50000, 3.6),
                new Employee(127, "Shreeja", 85000, 4.5),
                new Employee(509, "Daniel", 60000, 4.0),
                new Employee(344, "Lucy", 94000, 4.7),
                new Employee(509, "Harry", 75000, 4.3),
                new Employee(344, "Emma", 55000, 3.7)
        );

        // toMultiMap(key, value)
        // Se usa toMultiMap para que un valor posterior no sustituya al anterior
        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), emp -> emp.getName()))
                .subscribe(System.out::println);

        System.out.println();

        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toList())
                .subscribe(System.out::println);
    }
}
