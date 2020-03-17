package queue;

public abstract class AbstractQueue implements Queue{
    public int length=0;
    

    public abstract void enqueue(Object element);

    public abstract Object dequeue();

    public abstract Object element();

    public abstract void clear();

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public abstract String toStr();

    public abstract Object[] toArray();
}

