package f13_data_structures_functional_way.f02_queue;

import f06_functional_programming_in_depth.f04_chaining.Consumer;
import f13_data_structures_functional_way.f01_list.ListFun;

// Cola - FIFO (first input first output)
// Tenemos que hacer el traversing de la lista para insertar elementos, por lo que no es muy eficiente añadir
// elementos. Para evitar este problema se hacen dos listas, una llamada front y la otra rear, ambas con
// un head y un tail.
public class QueueFun<T> {

    private final ListFun<T> front;
    private final ListFun<T> rear;

    public QueueFun() {
        this.front = ListFun.list();
        this.rear = ListFun.list();
    }

    // Empty Queue
    // Static Factory Method
    public static <T> QueueFun<T> queue() {
        return new QueueFun<T>();
    }

    public QueueFun(QueueFun<T> queue, T element) {
        boolean frontIsEmpty = queue.front.isEmpty();
        this.front = frontIsEmpty ? queue.front.addElement(element) : queue.front;
        this.rear = frontIsEmpty ? queue.rear : queue.rear.addElement(element);
    }

    // enqueue
    public QueueFun<T> enqueue(T t) {
        return new QueueFun<T>(this, t);
    }

    // dequeue
    private QueueFun(ListFun<T> front, ListFun<T> rear) {
        final boolean frontIsEmpty = front.isEmpty();
        this.front = frontIsEmpty ? rear.reverseList() : front;
        this.rear = frontIsEmpty ? front : rear;
    }

    public QueueFun<T> dequeue() {
        return new QueueFun<T>(this.front.tail(), rear);
    }

    // forEach
    void forEach(Consumer<? super T> action) {
        T current = this.front.head();
        ListFun<T> temp = ListFun.concat(this.front.tail(), this.rear.reverseList());
        while (temp != null) {
            action.accept(current);
            current = temp.head();
            temp = temp.tail();
        }
    }

    public int size() {
        return front.length() + rear.length();
    }

    public T peek() {
        if (this.size() == 0) {
            return null;
        }

        return this.front.head();
    }

    public boolean isEmpty() {
        return this.front.isEmpty() && this.rear.isEmpty();
    }
}
