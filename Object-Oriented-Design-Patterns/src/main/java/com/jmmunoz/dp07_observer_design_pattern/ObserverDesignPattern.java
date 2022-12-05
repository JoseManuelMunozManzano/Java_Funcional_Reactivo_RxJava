package com.jmmunoz.dp07_observer_design_pattern;

import java.util.Iterator;
import java.util.List;

// Es un patrón de comportamiento.
// El patrón de diseño Observer define de una a muchas dependencias entre objetos, y cuando un objeto cambia su estado,
// todos sus objetos dependientes son notificados o actualizados automáticamente.
//
// Tenemos un Subject que se usa para registrar o dar de baja Observers.
// Contiene el estado.
// Si cambia, el Observer necesita ser notificado.
//
// Cuando el Observer es notificado por el Subject, el Observer llama al Subject para obtener la data actualizada.
//
// To-do lo que hemos visto en programación reactiva se basa en esto, un Observable
// que emite la data y los Observers que reciben esa data.
//
// Cuando usar el patrón Observer:
//  - Cuando objetos separados nos permiten modicarlos y reusarlos independientemente.
//  - Cuando un cambio en un objeto requiere cambiar otros, y no sabemos cuántos objetos necesitan cambiarse.
//  - Cuando un objeto debería ser capaz de notificar a otros objetos sin hacer suposiciones sobre quienen son
//      esos objetos.
//
// JDS usa el patrón Observer en:
//  java.util.EventListener en Swing
//  javax.servlet.http.HttpSessionBindingListener
//  javax.servlet.http.HttpSessionAttributeListener
public class ObserverDesignPattern {

    public static void main(String[] args) {
        // Observable
        Book book = new Book("Goosebumps", "Horror", 200, "Xyz", "SoldOut");

        // Observers
        EndUser user1 = new EndUser("Adri", book);
        EndUser user2 = new EndUser("Jose", book);

        List<Observer> subscribers = book.getObsList();
        for (Iterator<Observer> itr = subscribers.iterator(); itr.hasNext(); ) {
            EndUser eu = (EndUser) itr.next();
            System.out.println(eu + " has subscribed for " + book.getName() + " Book");
        }

        System.out.println(book.getInStock());

        System.out.println("Book is now available");
        book.setInStock("In Stock");
    }
}
