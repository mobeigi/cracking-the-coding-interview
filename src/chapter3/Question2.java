package chapter3;

import Interfaces.GenericStack;

import java.util.EmptyStackException;
import java.util.HashMap;

/**
 * Stack Min
 *
 * @implSpec How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * @implNote Normally this wouldn't be possible as at the very least least either push/pop or min would have to include
 * some sort of sort/search in log(N) time. However, as this is a stack we pop off values in a specific order based on
 * last values pushed.
 *
 * Our solution involves maintaining a linked list of minValues and a frequency map. Our linked list contains a list of
 * minimum values encountered. Each time a new value is pushed on the stack that is smaller than the head of the
 * minValues list, it is pushed to the list. Our min function simply returns the head of this list in O(1) time.
 *
 * We manipulate our frequency map in the push/pop functions, updating the frequency every time a value is pushed/popped.
 * In pop(), if we just popped the last copy of an element which also happened to be the minimum value, we move our
 * minimumValue list to the next minimum value in O(1).
 * In push(), we either handle the first insert case or check if this new insert is smaller than our current minimum
 * value and update our minimumValue list to add a new head in O(1).
 *
 * Thus, min, pop and push are all O(1) as required at the cost of high space complexity.
 *
 * [EXTERNAL] Could also have added 'min' element to each node which tracks minimum at each stack state.
 */
public class Question2<T extends Comparable<T>> implements GenericStack<T> {

    private Node<T> head;
    private int size = 0;

    private Node<T> minValues;
    private HashMap<T, Integer> freqMap;

    //Constructor
    public Question2() {
        freqMap = new HashMap<>();
    }

    /**
     * Pop element off stack and return it
     *
     * @return element that was popped off stack
     * @throws EmptyStackException if stack is empty
     */
    @Override
    public T pop() throws EmptyStackException {
        if (size == 0)
            throw new EmptyStackException();

        T val = head.val;
        head = head.next;
        --size;

        //Min functionality
        freqMap.put(val, freqMap.get(val) - 1);
        if (freqMap.get(val) == 0 && val.compareTo(minValues.val) == 0) {
            //Set to next min value
            minValues = minValues.next;
        }

        return val;
    }

    /**
     * Push onto stack
     *
     * @param item item to push onto stack
     */
    @Override
    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        ++size;

        //Min functionality
        freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);

        //First insert case
        if (minValues == null)
            minValues = new Node<>(item);
        else {
            //Update min node if value of this node is smaller
            if (item.compareTo(minValues.val) < 0) {
                Node<T> newNode = new Node<>(item);
                newNode.next = minValues;
                minValues = newNode;
            }
        }
    }

    /**
     * Peek into stack
     *
     * @return value of top element in stack
     * @throws EmptyStackException if stack is empty
     */
    @Override
    public T peek() throws EmptyStackException {
        if (size == 0)
            throw new EmptyStackException();
        return head.val;
    }

    /**
     * Return minimum element
     *
     * @return minimum element in stack
     * @throws EmptyStackException if stack is empty
     */
    public T min() throws EmptyStackException {
        if (size == 0)
            throw new EmptyStackException();
        return minValues.val;
    }
    /**
     * Get size of stack
     *
     * @return size of stack
     */
    @Override
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
    public static <T extends Comparable<T>> void print(Question2<T> stack) {
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
