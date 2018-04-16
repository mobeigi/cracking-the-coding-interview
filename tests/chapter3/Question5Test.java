package chapter3;

import Helpers.Stack;
import Interfaces.GenericStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question5Test {
    @Test
    void sortStackClass() {
        Question5<Integer> question5 = new Question5<>();

        question5.push(10);
        question5.push(10);
        question5.push(6);
        question5.push(2);
        question5.push(52);
        question5.push(-5);
        question5.push(35);
        question5.push(-20);

        //Stack order should be: -5,2,6,10,10,35,52
        assertEquals(Integer.valueOf(-20), question5.pop());
        assertEquals(Integer.valueOf(-5), question5.pop());
        assertEquals(Integer.valueOf(2), question5.pop());
        assertEquals(Integer.valueOf(6), question5.pop());
        assertEquals(Integer.valueOf(10), question5.pop());
        assertEquals(Integer.valueOf(10), question5.pop());
        assertEquals(Integer.valueOf(35), question5.pop());
        assertEquals(Integer.valueOf(52), question5.pop());
    }

    @Test
    void sortStackStaticMethod() {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(-54);
        s.push(18);
        s.push(-65);
        s.push(0);
        s.push(0);
        s.push(39);
        s.push(9);
        s.push(-2);

        GenericStack<Integer> sortedStack = Question5.sortStack(s);
        //Stack order should be: -65,-54,-2,0,0,2,9,18,39
        assertEquals(Integer.valueOf(-65), sortedStack.pop());
        assertEquals(Integer.valueOf(-54), sortedStack.pop());
        assertEquals(Integer.valueOf(-2), sortedStack.pop());
        assertEquals(Integer.valueOf(0), sortedStack.pop());
        assertEquals(Integer.valueOf(0), sortedStack.pop());
        assertEquals(Integer.valueOf(2), sortedStack.pop());
        assertEquals(Integer.valueOf(9), sortedStack.pop());
        assertEquals(Integer.valueOf(18), sortedStack.pop());
        assertEquals(Integer.valueOf(39), sortedStack.pop());

    }
}