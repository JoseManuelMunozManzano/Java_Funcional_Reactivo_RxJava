package f13_data_structures_functional_way.f04_map;

// Se va a implementar un hashmap. Se usa hashing para almacenar un par clave-valor.
// hashing es una técnica en la que se genera un número único llamado código hash al transformar la clave
// ya que la clave es única y luego se usa ese hashcode para calcular el índice en el que esa clave-valor
// se va a almacenar en la tabla hash.
// Es decir, se calcula el índice utilizando la clave.
// Ejemplo: Hashcode = (key * n) % size;
//
// Como siempre que hablamos de programación funcional, este diseño debe ser:
// Persistente
// Inmutable
public class MapFP {

    public static void main(String[] args) {
        MapFun<Integer, String> map = new MapFun<>(5);
        map.put(1, "Adri");
        map.put(2, "José");
        map.put(3, "Tania");
        map.put(5, "Marina");
        map.put(100, "Jaimito");

        map.display();
    }
}
