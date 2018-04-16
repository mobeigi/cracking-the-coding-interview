package chapter3;

import Helpers.Stack;
import Interfaces.GenericStack;

/**
 * Sort Stack
 *
 * @implSpec Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 * @implNote Very similar to Question 4. We simply pop off elements off our mainStack while our item is larger
 * than the top element in the stack. When it is not then it is less than the element and thus can be placed in that
 * sorted position. Finally, we simply pop off tmpStack back onto the main stack preserving the previous sorted
 * ordering.
 *
 * A static sort method was also created that uses the underlying Question5 stack to create a sorted stack.
 *
 */
public class Question5<T extends Comparable<T>> implements GenericStack<T> {
    private Stack<T> mainStack;
    private Stack<T> tmpStack;

    public Question5() {
        this.mainStack = new Stack<>();
        this.tmpStack = new Stack<>();
    }

    @Override
    public T pop() {
        return mainStack.pop();
    }

    @Override
    public void push(T item) {

        //Pop and push off all larger elements onto tmp stack
        while (!mainStack.isEmpty() && item.compareTo(mainStack.peek()) > 0) {
            tmpStack.push(mainStack.pop());
        }

        //Add item to mainstack in its sorted position
        mainStack.push(item);

        //Put all tmpStack elements back onto mainStack
        while(!tmpStack.isEmpty()) {
            mainStack.push(tmpStack.pop());
        }
    }

    @Override
    public T peek() {
        return mainStack.peek();
    }

    @Override
    public int size() {
        return mainStack.size();
    }

    /**
     * Given an input stack, returns a sorted stack with smaller values at the top of the stack.
     *
     * @param stack input stack to sort
     * @param <T> Type of item in stack
     * @return sorted GenericStack with smaller values at top of stack
     */
    static <T extends Comparable<T>> GenericStack<T> sortStack(GenericStack<T> stack) {
        GenericStack<T> sortedStack = new Question5<T>();
        while (!stack.isEmpty()) {
            sortedStack.push(stack.pop());
        }
        return sortedStack;
    }

}
