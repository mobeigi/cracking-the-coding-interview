package Interfaces;

public interface GenericStack<T> {
    public T pop();
    public void push(T item);
    public T peek();
    public int size();
    public default boolean isEmpty() {
        return size() == 0;
    }
}
