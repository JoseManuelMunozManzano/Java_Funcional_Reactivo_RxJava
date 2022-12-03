package com.jmmunoz.reactive.r03_rxjava_operators.r02_types_of_operators;

// Los tipos de Operators que hay son:
// 1. Suppressing operators
//      Suprimen las emisiones que no cumplen un criterio especificado
//      El más común es: filter(Predicate condition)
//      Otros operadores son: take(), skip(), distinct(), elementAt()
// 2. Transforming operators
//      Transforman las emisiones de un Observable y devuelven otro Observable que podría no ser del mismo tipo
//      El más común es: map(Function mapper)
//      Otros operadores son: cast(), delay(), delaySubscription(), scan(), sorted(), repeat()...
// 3. Reducing operators
//      Toman un conjunto de emisiones y las reduce a una sola emisión
//      Trabajan con Observables finitos
//      El más común es: reduce()
//      Otros operadores son: count(), contains(), all(), any(),
// 4. Collection Operators
//      Combinan todas las emisiones en un tipo de colección
//      Es otro tipo de Reducing operators, ya que reducen las emisiones a una colección
//      Los operadores son: toList(), toSortedList(), toMap(), collect()...
// 5. Error-recovery operators
//      Se usan para manejar los errores y recuperarse de ellos
//      Ejemplos de operadores son: onErrorReturnItem(), onErrorReturn(), onErrorResumeNext(), retry()
// 6. Action operators
//      Se usan para hacer debug en la cadena del Observable
//      Ejemplos de operadores son: doOnNext(), doOnError(), doOnSubscribe(), doOnComplete()...
public class TypesOfOperators {
}
