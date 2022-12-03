package f05_optional_for_null_pointer.f01_introducing_optional;

import java.util.Optional;

public class OptionalCreation {

    public static void main(String[] args) {
        String val = "A String";

        // Optional es una caja que envuelve un valor. Consume 16 bytes y es un Objeto separado.
        // Es inmutable, por lo que no puede cambiarse el valor una vez creado.
        // Crear un Optional tiene un costo en rendimiento, ya que crea un objeto. Por tanto, no hay que sustituir
        // null con Optional si realmente no es necesario.
        // Pero como ventaja tiene que indicamos al programador que tenga cuidado con esa variable porque puede
        // ser null y hay que manejar esa posibilidad.

        // Tres formas de crear un Optional

        // Con Optional.of
        // Ahora val queda envuelto en un Optional
        Optional<String> optional = Optional.of(val);

        // Con empty()
        // Un empty Optional (también lo veremos creado con ofNullable)
        Optional<Integer> empty = Optional.empty();

        // Con ofNullable()
        // Si no estamos seguros si la variable contiene un valor o null
        Optional<String> nullable = Optional.ofNullable(val);
        Optional<String> emptyOptional = Optional.ofNullable(null);

        // Una vez creado un Optional podemos aplicar todas las operaciones sobre ese Optional sin temer la excepción
        // NullPointerException
        // Luego recuperaremos el resultado del Optional.
    }
}
