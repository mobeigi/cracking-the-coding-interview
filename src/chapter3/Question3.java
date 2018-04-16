package chapter3;

import Helpers.Stack;
import Interfaces.GenericStack;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Stack of Plates
 *
 * @implSpec Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
 * we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks. push () and SetOfStacks. pop () should behave identically to a
 * single stack (that is, pop ( ) should return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP: Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 *
 * @implNote We will use our generic implementation of a stack. We store an ArrayList of stacks. When the latest stack
 * which is the stack at the last index int he ArrayList is full (reached quantity) we create a new stack. When a stack
 * has 0 elements we remove it from the ArrayList which still keeps all elements in the correct order. This means that
 * stacks other than the last stack may not be at full capacity, this improved time complexity at the cost of extra
 * space complexity caused by having sparse stacks. We push only at the lastStack. We implement pop using popAt(index)
 * by giving it the index of the last stack.
 *
 * [EXTERNAL] Could have also interpreted requirements as requiring all stacks except last to be at full capacity which
 * would involve moving elements across the stacks when using popAt()
 */
public class Question3<T> implements GenericStack<T> {

    private ArrayList<Stack<T>> stacks;
    private int threshold;
    private int size = 0;

    //Constructor
    public Question3(int threshold) {
        this.threshold = threshold;
        stacks = new ArrayList<>();
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

        return popAt(stacks.size()-1);
    }

    /**
     * Pop element off stack at a particular index
     *
     * @param index stack index to pop element off
     * @return  element popped off stack at provided index
     * @throws IndexOutOfBoundsException if index out of bounds
     */
    public T popAt(int index) throws IndexOutOfBoundsException{
        if (index > stacks.size() - 1)
            throw new IndexOutOfBoundsException();

        Stack<T> curStack = stacks.get(index);

        T val = curStack.pop();
        if (curStack.size() == 0) {
            stacks.remove(curStack);
        }
        --size;
        return val;
    }

    /**
     * Push onto stack
     *
     * @param item item to push onto stack
     */
    @Override
    public void push(T item) {
        if (stacks.size() == 0)
            stacks.add(new Stack<>());

        Stack<T> curStack = stacks.get(stacks.size()-1);
        if (curStack.size() == threshold) {
            stacks.add(new Stack<>());
            curStack = stacks.get(stacks.size()-1);
        }

        curStack.push(item);
        ++size;
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

        return stacks.get(stacks.size()-1).peek();
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

    public int getNumberOfStacks() {
        return stacks.size();
    }
}
