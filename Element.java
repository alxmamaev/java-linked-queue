package queue;
import java.util.Arrays;

public class Element{
    private Object value;
    private Element next;

    public Element(Object element){
        assert element != null; 

        value = element;
    }

    public void setNext(Element node){
        assert node != null; 

        next = node;
    }

    public Object get(){
        return value;
    }

    public Element getNext(){
        return next;
    }
}