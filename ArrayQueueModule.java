package queue;
import java.util.Arrays;

public class ArrayQueueModule {
    private static int start;
    private static int end;
    private static int length;
    private static Object[] elements = new Object[10];

    public static void enqueue(Object element) {
        assert element != null;

        ensureCapacity(end + 1);
        elements[end++] = element;
        end = end % elements.length;
        length++;
    }

    private static void ensureCapacity(int new_end) {
        if (new_end % elements.length == start) {
            Object[] _elements = new Object[elements.length * 2];
            for(int i=start; i<elements.length; i++){
                _elements[i - start] = elements[i];
            }

            if(end < start)
                for(int i=0; i<end; i++){
                    _elements[elements.length - start + i] = elements[i];
                }

            elements = _elements;
            start = 0;
            end = length;
        }
    }

    public static Object dequeue() {
        assert length > 0;

        Object value = element();
        elements[start] = null;
        start++;
        start = start % elements.length;
        length--;

        if(length == 0){
            start = 0;
            end = 0;
        }

        return value;
    }

    public static Object element() {
        assert length > 0;

        return elements[start];
    }

    public static int size() {
        return length;
    }

    public static boolean isEmpty() {
        return length == 0;
    }
    
    public static void clear() {
        start = 0;
        end = 0;
        length = 0;
    }

    public static String toStr(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if(end >= start){
            for(int i=start; i<end; i++){
                sb.append(elements[i].toString());
                if(i != end - 1)
                    sb.append(", ");
            }
        }
        else{
            for(int i=start; i<elements.length; i++){
                sb.append(elements[i].toString());
                if(i != elements.length - 1)
                    sb.append(", ");
            }

            if(end != 0 && start != elements.length)
                sb.append(", ");
            
            for(int i=0; i<end; i++){
                sb.append(elements[i].toString());
                if(i != end - 1)
                    sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
