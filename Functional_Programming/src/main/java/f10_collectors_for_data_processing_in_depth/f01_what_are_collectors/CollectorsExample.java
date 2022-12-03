package f10_collectors_for_data_processing_in_depth.f01_what_are_collectors;

// Sirve para facilitar la vida cuando se procesa una gran cantidad de datos en memoria.
// Collectors consta de algoritmos de reducción como acumulación de elementos en una colección,
// resumir elementos de acuerdo a varios criterios...
// Collectors tiene esta firma
// public final class Collectors {}
// Todos sus métodos son estáticos y devuelven una instancia de Collector.
// Para recolectar los datos se usa una operación reduce()
// Por tanto, el algoritmo típico para usar Collectors sería el siguiente:
// .collect()
// public interface Collector<T, A, R> {
//  Implementación que realiza reducciones (Una operación de reducción mutable que acumula elementos de entrada en un
//  contenedor de resultado mutable)
// }
// List list = stream.collect(Collectors.toList());
public class CollectorsExample {
}
