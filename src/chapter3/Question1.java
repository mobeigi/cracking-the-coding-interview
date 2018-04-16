package chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Three in One
 *
 * @implSpec Describe how you could use a single array to implement three stacks.
 *
 * @implNote This implementation uses one underlying array (of type int in this case). We maintain an index
 * 'nextAvailablePosition' which points to the next available position for insertion. Upon insertion, we insert into
 * the array at this index if the value is null, otherwise we iterate around the array upto N (using modulo operator to
 * stay within bounds) until null element is found for insertion. If no null element founds, we simply fail but we could
 * have also resized our array, copied values over and continued (with amortized constant time).
 *
 * We have a list of stacks that are simply a linked list of indices into the data array. Thus, all of our data in the
 * array is mixed and can belong to any one of the stacks.
 *
 */
public class Question1 {
    private Integer[] arr;
    private int nextAvailablePosition = 0;
    private int numberOfStacks;
    private ArrayList<LinkedList<Integer>> stacks;

    /**
     * Default constructor
     */
    public Question1() {
        this(1);
    }

    /**
     * Constructor
     * @param numberOfStacks how many stacks will share our array
     */
    public Question1(int numberOfStacks) {
        arr = new Integer[1000]; //initial size
        stacks = new  ArrayList<LinkedList<Integer>>(){};
        this.numberOfStacks = numberOfStacks;

        for (int i = 0; i < numberOfStacks; ++i) {
            stacks.add(new LinkedList());
        }
    }

    /**
     * Pop element off stack
     *
     * @param stackNumber the number of stack you are referencing
     * @return  popped element from stack at stackNumber
     * @throws EmptyStackException if stack with stackNumber is empty
     */
    public int pop(int stackNumber) throws EmptyStackException {
        LinkedList<Integer> stack = stacks.get(stackNumber);
        if (stack.isEmpty())
            throw new EmptyStackException();

        //Get value and remove value from stack
        int value = arr[stack.getFirst()];
        arr[stack.getFirst()] = null;
        stack.removeFirst();

        return value;
    }

    /**
     * Push element onto stack
     *
     * @param stackNumber the number of stack you are referencing
     * @param item item to insert into stack
     * @throws Exception if array exhausted (we fail)
     */
    public void push(int stackNumber, int item) throws Exception {
        LinkedList<Integer> stack = stacks.get(stackNumber);

        int count = 0;
        while (arr[nextAvailablePosition] != null) {
            nextAvailablePosition = (nextAvailablePosition + 1) % arr.length;
            ++count;
            if (count == arr.length)
                throw new Exception("Array exhausted");
        }

        arr[nextAvailablePosition] = item;
        stack.addFirst(nextAvailablePosition);
        nextAvailablePosition = (nextAvailablePosition + 1) % arr.length;
    }

    /**
     * Peek into stack
     *
     * @param stackNumber the number of stack you are referencing
     * @return element at the top of stack with stackNumber
     * @throws EmptyStackException if stack with stackNumber is empty
     */
    public int peek(int stackNumber) throws EmptyStackException {
        LinkedList<Integer> stack = stacks.get(stackNumber);
        if (stack.isEmpty())
            throw new EmptyStackException();

        return arr[stack.getFirst()];
    }

    /**
     * Check if stack empty
     *
     * @param stackNumber the number of stack you are referencing
     * @return true if stack empty, false otherwise
     */
    public boolean isEmpty(int stackNumber) {
        return stacks.get(stackNumber).isEmpty();
    }

    /**
     * Print stack out in linked list format
     * @param stackNumber the number of stack you are referencing
     */
    public void print(int stackNumber) {
        LinkedList<Integer> stack = stacks.get(stackNumber);
        for (Integer integer : stack) {
            System.out.print(arr[integer] + "->");
        }
        System.out.println("X");
    }
}
