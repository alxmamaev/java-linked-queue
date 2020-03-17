package queue;

public class ArrayQueueTest {
    public static void fill(AbstractQueue queue) {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
    }

    public static void dump(AbstractQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " +
                queue.element() + " " + queue.dequeue());
        }
    }

    public static void main(String[] args) {
        AbstractQueue queue = new ArrayQueue();
        fill(queue);
        System.out.println(queue.toStr());
        dump(queue);
        System.out.println(queue.toStr());


        AbstractQueue queue_linked = new LinkedQueue();
        fill(queue_linked);
        System.out.println(queue_linked.toStr());
        dump(queue_linked);
        System.out.println(queue_linked.toStr());
    }
}
