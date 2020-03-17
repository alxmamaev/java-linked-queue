package queue;

public interface Queue{

    // Pre: element != null
    // Post: elements = elements' + [element]; length = length' + 1
    public void enqueue(Object element);

    // Pre:
    // Post: elements = elements' ; length = length' + 1
    public Object dequeue();

    // Pre: length > 0
    // Post: returns elements[start]
    public Object element();

    // Pre:
    // Post: length=0; start=0; end=0
    public void clear();

    // Pre:
    // Post: returns length
    public int size();

    // Pre:
    // Post: returns true if length == 0
    public boolean isEmpty();

    // Pre: 
    // Post: returns String "elements[0], elements[1], ..., elements[length-1]"
    public String toStr();
}