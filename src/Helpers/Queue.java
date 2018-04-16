package Helpers;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    //Constructor
    public Queue() {}

    /**
     * Add to queue
     * @param item item to add to queue
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (size == 0)
            head = newNode;
        else
            tail.next = newNode;

        tail = newNode;
        ++size;
    }

    /**
     * Remove from queue
     *
     * @return remove first item from queue and return it
     * @throws NoSuchElementException if queue empty
     */
    public T remove() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();

        T val = head.val;
        head = head.next;
        --size;
        return val;
    }

    /**
     * Peek into queue
     *
     * @return tio if queue
     * @throws NoSuchElementException if queue empty
     */
    public T peek() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();

        return head.val;
    }

    /**
     * Check if queue is empty
     * @return true if queue empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Get size of queue
     *
     * @return size of stack
     */
    public int size() {
        return size;
    }

    /**
     * Print Queue
     * -> indicates next element
     * X indicates NULL value
     *
     * @param queue queue to print
     * @param <T> type of values in queue
     */
    public static <T> void print(Queue<T> queue) {
        StringBuilder sb = new StringBuilder();
        Node<T> node = queue.head;
        while(node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        sb.append("X"); //final null

        System.out.println(sb.toString());
    }

    /**
     * Linked list node used to implement queue
     * @param <T> Type for value in stack
     */
    private static class Node<T> {
        private T val;
        private Node<T> next;

        Node(T data) {
            this.val = data;
        }
    }

}
