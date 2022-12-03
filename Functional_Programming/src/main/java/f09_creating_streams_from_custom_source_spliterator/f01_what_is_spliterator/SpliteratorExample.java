package f09_creating_streams_from_custom_source_spliterator.f01_what_is_spliterator;

// Spliterator es una interface que al implementarla conecta un stream a una fuente personalizada.
// Es un objeto para acceder a la data que el stream puede usar.
// Se usa para conectar un stream a una fuente personalizada, como un File, pero también se puede usar en
// colecciones. La clase Collections posee su propia implementación de Spliterator, que se utiliza por debajo cuando
// se crean streams.
// Pero cuando se usa sobre una fuente personalizada, tenemos que crear nuestro propio Spliterator
// Consta de 4 métodos abstractos que hay que implementar:
// tryAdvance --> Si existe un elemento restante realiza la acción sobre él y devuelve un booleano.
// trySplit() --> Separa los elementos. Muy útil en procesamiento paralelo.
// estimateSize() --> Devuelve un número estimado de elementos que pueden encontrarse en un forEach.
// characteristics() --> Devuelve un conjunto de características de Spliterator.
public class SpliteratorExample {
}
