package Helpers;

import Interfaces.GenericStack;

import java.util.EmptyStackException;

/**
 * Definition for stack using nodes
 *
 * @param <T> Type for value in stack
 */
public class Stack<T> implements GenericStack<T> {

    private Node<T> head;
    private int size = 0;

    //Constructor
    public Stack() {}

    /**
     * Pop element off stack and return it
     *
     * @return element that was popped off stack
     * @throws EmptyStackException if stack is empty
     */
    public T pop() throws EmptyStackException {
        if (size == 0)
            throw new EmptyStackException();

        T val = head.val;
        head = head.next;
        --size;
        return val;
    }

    /**
     * Push onto stack
     *
     * @param item item to push onto stack
     */
    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        ++size;
    }

    /**
     * Peek into stack
     *
     * @return value of top element in stack
     * @throws EmptyStackException if stack is empty
     */
    public T peek() throws EmptyStackException {
        if (size == 0)
            throw new EmptyStackException();
        return head.val;
    }

    /**
     * Check if stack is empty
     * @return true if stack empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Get size of stack
     *
     * @return size of stack
     */
    public int size() {
        return size;
    }


    /**
     * Print Stack
     * -> indicates next element
     * X indicates NULL value
     *
     * @param stack stack to print
     * @param <T> type of values in stack
     */
    public static <T> void print(Stack<T> stack) {
        StringBuilder sb = new StringBuilder();
        Node<T> node = stack.head;
        while(node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        sb.append("X"); //final null

        System.out.println(sb.toString());
    }

    /**
     * Linked list node used to implement stack
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
