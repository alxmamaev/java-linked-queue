package queue;
import java.util.Arrays;

public class LinkedQueue extends AbstractQueue{
    private Element start;
    private Element end;
    

    @Override
    public void enqueue(Object element){
        Element node = new Element(element);
        if(length == 0){
            start = node;
            end = node;
        }
        else{
            end.setNext(node);
            end = node;
        }

        length++;
    }

    @Override
    public Object dequeue(){
        assert length > 0;

        Object value = element();

        start = start.getNext();
        length--;

        return value;
    }

    @Override
    public Object element(){
        assert length > 0;

        return start.get();
    }

    @Override
    public void clear(){
        start = null;
        end = null;
        length = 0;
    }

    @Override
    public String toStr(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Element current = start;
        if(length > 0){
            while(current != end){
                sb.append(current.get().toString());
                current = current.getNext();
                sb.append(", ");
            }
            sb.append(current.get().toString());
        }

        sb.append("]");
        return sb.toString();
    }


    @Override
    public Object[] toArray(){
        Object[] output_array  = new Object[length];
        
        Element current = start;
        int indx = 0;
        if(length > 0){
            while(current != end){
                output_array[indx] = current.get();
                current = current.getNext();


                indx++;
            }

            output_array[indx] = current.get();
        }

        return output_array;
    }
}