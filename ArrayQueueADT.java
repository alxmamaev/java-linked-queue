package queue;
import java.util.Arrays;

public class ArrayQueueADT {
    private /*static*/ int start;
    private /*static*/ int end;
    private /*static*/ int length;
    private /*static*/ Object[] elements = new Object[10];

    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue, queue.end + 1);
        queue.elements[queue.end++] = element;
        queue.end %= queue.elements.length;
        queue.length++;
        
    }

    private static void ensureCapacity(ArrayQueueADT queue, int new_end) {
        if (new_end % queue.elements.length == queue.start) {
            Object[] _elements = new Object[queue.elements.length * 2];
            for(int i=queue.start; i<queue.elements.length; i++){
                _elements[i - queue.start] = queue.elements[i];
            }

            for(int i=0; i<queue.end; i++){
                _elements[queue.elements.length - queue.start + i] = queue.elements[i];
            }

            queue.elements = _elements;
            queue.start = 0;
            queue.end = queue.length;
        } 
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.length > 0;

        Object value = element(queue);
        queue.elements[queue.start] = null;
        queue.start++;
        queue.start = queue.start % queue.elements.length;
        queue.length--;

        if(queue.length == 0){
            queue.start = 0;
            queue.end = 0;
        }

        return value;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.start = 0;
        queue.end = 0;
        queue.length = 0;
    }

    public static Object element(ArrayQueueADT queue) {
        assert queue.length > 0;

        return queue.elements[queue.start];
    }
    public static int size(ArrayQueueADT queue) {
        return queue.length;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.length == 0;
    }

    public static String toStr(ArrayQueueADT queue){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if(queue.end >= queue.start){
            for(int i=queue.start; i<queue.end; i++){
                sb.append(queue.elements[i].toString());
                if(i != queue.end - 1)
                    sb.append(", ");
            }
        }
        else{
            for(int i=queue.start; i<queue.elements.length; i++){
                sb.append(queue.elements[i].toString());
                if(i != queue.elements.length - 1)
                    sb.append(", ");
            }

            if(queue.end != 0 && queue.start != queue.elements.length)
                sb.append(", ");
            
            for(int i=0; i<queue.end; i++){
                sb.append(queue.elements[i].toString());
                if(i != queue.end - 1)
                    sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
