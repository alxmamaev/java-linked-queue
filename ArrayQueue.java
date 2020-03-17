package queue;

public class ArrayQueue extends AbstractQueue{
    private int start;
    private int end;
    private Object[] elements = new Object[10];

    // Pre: element != null
    // Post: elements = elements' + [element]; length = length' + 1
    @Override
    public void enqueue(Object element) {
        assert element != null;

        // Pre: element != null, end >= 0
        // Post: elements.size <= length
        ensureCapacity(end + 1);

        // Pre: elements.size <= length
        // Post: end = end' + 1
        elements[end++] = element;

        // Pre: end > 0
        // Post: end < elements.length
        end = end % elements.length;

        // Pre: length > 0
        // Post: length = length' + 1;
        length++;
    }

    //Post: elements.size <= lengths
    private void ensureCapacity(int new_end) {
        if (new_end % elements.length == start) {
            // pre: new_end % elements.length == start

            // Pre: elements.length < length '
            // Post: elements.length = elements.length' * 2

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

    // Pre: length > 0
    // Post: length -= 1; elements[start'] = None; start = start' + 1
    @Override 
    public Object dequeue() {
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

    // Pre: length > 0
    // Post: returns elements[start]
    @Override
    public Object element() {
        assert length > 0;

        return elements[start];
    }

    // Pre:
    // Post: length=0; start=0; end=0
    @Override
    public void clear() {
        start = 0;
        end = 0;
        length = 0;
    }

    // Pre:
    // Post: returns String "elements[0], elements[1], ..., elements[length-1]"
    @Override
    public String toStr(){
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


    @Override
    public Object[] toArray(){
        Object[] output_array  = new Object[length];
        int indx = 0;
        
        if(end >= start){
            for(int i=start; i<end; i++){
                output_array[indx] = elements[i];
                indx++;
            }
        }
        else{
            for(int i=start; i<elements.length; i++){
                output_array[indx] = elements[i];
                indx++;
            }

            for(int i=0; i<end; i++){
                output_array[indx] = elements[i];
                indx++;
            }
        }
        
        return output_array;
    }
}
