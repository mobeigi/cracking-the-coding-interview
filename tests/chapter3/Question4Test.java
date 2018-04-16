package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question4Test {

    @Test
    void queueViaStacks() {
        Question4<Integer> question4 = new Question4<>();

        question4.push(10);
        assertEquals(Integer.valueOf(10), question4.peek());
        assertEquals(1, question4.size());
        question4.push(20);
        assertEquals(Integer.valueOf(10), question4.peek());
        assertEquals(2, question4.size());
        question4.push(-32);
        assertEquals(Integer.valueOf(10), question4.peek());
        assertEquals(3, question4.size());
        question4.push(17);
        assertEquals(Integer.valueOf(10), question4.peek());
        assertEquals(4, question4.size());
        question4.pop();
        assertEquals(Integer.valueOf(20), question4.peek());
        assertEquals(3, question4.size());
        question4.pop();
        assertEquals(Integer.valueOf(-32), question4.peek());
        assertEquals(2, question4.size());
        question4.pop();
        assertEquals(Integer.valueOf(17), question4.peek());
        assertEquals(1, question4.size());
        question4.push(203);
        assertEquals(Integer.valueOf(17), question4.peek());
        assertEquals(2, question4.size());
        question4.pop();
        assertEquals(Integer.valueOf(203), question4.peek());
        assertEquals(1, question4.size());
        question4.push(205);
        assertEquals(Integer.valueOf(203), question4.peek());
        assertEquals(2, question4.size());
        question4.pop();
        assertEquals(Integer.valueOf(205), question4.peek());
        assertEquals(1, question4.size());
        question4.pop();
        assertEquals(0, question4.size());
    }
}