package queue;

public class ArrayQueueADTTest {
    public static void fill(ArrayQueueADT queue) {
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
    }

    public static void dump(ArrayQueueADT stack) {
        while (!ArrayQueueADT.isEmpty(stack)) {
            System.out.println(
                ArrayQueueADT.size(stack) + " " +
                ArrayQueueADT.element(stack) + " " +
                ArrayQueueADT.dequeue(stack)
            );
        }
    }

    public static void main(String[] args) {
        ArrayQueueADT queue = new ArrayQueueADT();
        fill(queue);
        System.out.println(ArrayQueueADT.toStr(queue));
        dump(queue);
    }
}
