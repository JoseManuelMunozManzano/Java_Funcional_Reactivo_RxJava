package f07_design_patterns.f06_builder;

// Builder Design Pattern consiste en proveer de flexibilidad la creación de un Objeto completo (muchos argumentos)
//      La idea de este patrón es aislar la construcción de un objeto completo de su representación.
//
// Ejemplos de Builder Pattern en JDK son java.lang.StringBuilder y java.lang.StringBuffer
public class BuilderPattern {

    public static void main(String[] args) {
        MobileBuilder builder = new MobileBuilder();

        Mobile myMobile = builder.with(myBuilder -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A15 Bionic";
            // No hace falta pasar null para los otros parámetros. Coge valores por defecto.
        }).createMobile();

        System.out.println(myMobile);
    }
}
