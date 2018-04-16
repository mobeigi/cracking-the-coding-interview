package chapter3;

import Helpers.Stack;
import Interfaces.GenericStack;

/**
 * Queue via Stacks
 *
 * @implSpec Implement a MyQueue class which implements a queue using two stacks.
 *
 * @implNote Works by using a secondary tmpStack. In a queue, we still pop from the head but we have to insert at
 * the back. Therefore, for each push operation, we pop from mainStack and push onto tmpStack. Next, we place our
 * new element to push at the bottom of mainStack. Finally, we pop from tmpStack and push on mainStack which reverses
 * the original operation and preserves the original ordering of all nodes in the stack. Thus we have effectively pushed
 * our new node to the end bottom of our stack which implements our queue.
 *
 */
public class Question4<T> implements GenericStack<T> {
    private Stack<T> mainStack;
    private Stack<T> tmpStack;

    public Question4() {
        this.mainStack = new Stack<>();
        this.tmpStack = new Stack<>();
    }

    @Override
    public T pop() {
        return mainStack.pop();
    }

    @Override
    public void push(T item) {
        //Put all mainStack elements on tmpStack
        while(!mainStack.isEmpty()) {
            tmpStack.push(mainStack.pop());
        }

        //Add item to mainstack at bottom
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
}
