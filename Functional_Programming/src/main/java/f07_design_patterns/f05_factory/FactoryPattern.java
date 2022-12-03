package f07_design_patterns.f05_factory;

// Factory Design Pattern es un patrón creacional que se usa para crear objetos sin exponer la lógica de instanciación.
//      El cliente no conoce nada del objeto que se va a crear.
//
// Como ejemplo tenemos la clase Calendar
// Calendar cal = Calendar.getInstance();
// No sabemos qué tipo de implementación concreta devuelve getInstance()
//
// En concreto, el patrón de diseño Factory es una forma de instanciar una clase dentro de un método designado llamado
// Factory Method.
// Factory es un objeto que puede crear otros objetos.
public class FactoryPattern {

    public static void main(String[] args) {

        // No sabemos que flooring vamos a obtener
        Flooring floor = FlooringFactory.getFlooring(-1, 18);
        floor.installation();

        System.out.println("---------------------------------- ");

        floor = FlooringFactory.getFlooring(13, 46);
        floor.installation();
    }
}
