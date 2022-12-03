package f13_data_structures_functional_way.f02_queue;

public class QueueFP {

    public static void main(String[] args) {
        QueueFun<String> q = QueueFun.queue();

        QueueFun<String> enqueue = q.enqueue("Hey").enqueue(" How are you?").enqueue(" Fine?");
        enqueue.forEach(System.out::println);

        System.out.println("\n------------------\n");

        QueueFun<String> dequeue = enqueue.dequeue();
        dequeue.forEach(System.out::println);

        System.out.println("\n------------------\n");

        System.out.println(dequeue.peek());

        System.out.println("\n------------------\n");

        System.out.println(dequeue.isEmpty());

        System.out.println("\n------------------\n");

        System.out.println(dequeue.size());
    }
}
