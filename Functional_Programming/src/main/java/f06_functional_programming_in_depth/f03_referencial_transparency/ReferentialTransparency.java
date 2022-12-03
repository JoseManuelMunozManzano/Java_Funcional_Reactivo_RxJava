package f06_functional_programming_in_depth.f03_referencial_transparency;

// Referencial Transparency es una propiedad de una función, variable o expresión por la cual la expresión
// puede ser sustituida por su (evaluado) valor sin afectar el comportamiento del programa.
// Aquí Transparency puede ser entendida como que no hay diferencia.
//
// Ejemplo:
// x = 7 + (2 * 4)
// Puede se sustituido sin afectar a su resultado por: x = 7 + (2 * 2 *2)
public class ReferentialTransparency {

    public static void main(String[] args) {
        int result = add(2, multiply(2, 4));
        System.out.println(result);

        // Obtengo el mismo resultado pasando estos valores
        // por lo que respeta la propiedad Referencial Transparency
        result = add(2, multiply(2, multiply(2, 2)));
        System.out.println(result);

        // Las funciones puras SIEMPRE respetan la propiedad Referencial Transparency.
        // Pero podría no ser pura y respetarla igualmente.
        //
        // La FP evita los métodos que no respetan la Referencial Transparency.
        // Y la usan porque:
        // 1. Hace más entendibles los programas
        // 2. Hace cada subprograma independiente, lo que simplifica enormemente las pruebas unitarias y la
        //    refactorización.
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        // Si añado esta línea entonces ya no respeta la propiedad Referencial Transparency
        // porque en el primer caso escribe una línea y en el segundo caso escribe dos líneas
        // System.out.println("Multiplying a and b : " + a + ", " + b);
        return a * b;
    }
}
