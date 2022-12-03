package com.jmmunoz.reactive.r03_rxjava_operators.r03_operators_in_action;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class OperatorsInAction {

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

        // Obteniendo los 4 mejores empleados para un nuevo proyecto
        obs
                .filter(e -> e.getRating() > 4.0)
                .sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating()))
                .map(e -> e.getName())
                .take(4)
                // .toList()        Este paso no haría falta si no nos hace falta una lista
                .subscribe(System.out::println);

        System.out.println();

        // Queremos conocer el gasto total acumulado mes por mes
        List<Integer> expenses = List.of(200, 500, 300, 340, 129, 234, 999, 1030, 3400, 890, 996, 789);

        Observable.fromIterable(expenses)
                .scan((a, b) -> a + b)
                .subscribe(System.out::println);

        System.out.println();

        // Gasto total en el año
        // Con reduce no se genera un resultado en cada paso
        Observable.fromIterable(expenses)
                .reduce((a, b) -> a + b)
                .subscribe(System.out::println);

    }
}
