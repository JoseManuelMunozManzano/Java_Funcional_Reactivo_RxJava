package r01_introduction.r04_observer_design_pattern;

// Observer Design Pattern: cuando un sujeto (observable) cambia su estado, todos sus objetos dependientes de él son
// notificados o actualizados automáticamente (observers).
public class ObserverDemo {

    public static void main(String[] args) {
        // Observable
        Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "SoldOut");

        // Observers
        EndUser user1 = new EndUser("Adri", book);
        EndUser user2 = new EndUser("Jose", book);

        System.out.println(book.getInStock());

        book.setInStock("In Stock");
    }
}
