package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question3Test {

    @Test
    void stackOfPlates() {
        Question3<Integer> question3 = new Question3<>(4); //threshold of 4

        question3.push(1);
        assertEquals(Integer.valueOf(1), question3.peek());
        assertEquals(1, question3.getNumberOfStacks());
        question3.push(17);
        assertEquals(Integer.valueOf(17), question3.peek());
        assertEquals(1, question3.getNumberOfStacks());
        question3.push(-42);
        assertEquals(Integer.valueOf(-42), question3.peek());
        assertEquals(1, question3.getNumberOfStacks());
        question3.push(13);
        assertEquals(Integer.valueOf(13), question3.peek());
        assertEquals(1, question3.getNumberOfStacks());
        assertEquals(4, question3.size());

        question3.push(105);
        assertEquals(Integer.valueOf(105), question3.peek());
        assertEquals(2, question3.getNumberOfStacks());
        question3.push(751);
        assertEquals(Integer.valueOf(751), question3.peek());
        assertEquals(2, question3.getNumberOfStacks());
        assertEquals(6, question3.size());

        assertEquals(Integer.valueOf(751), question3.pop());
        assertEquals(2, question3.getNumberOfStacks());
        assertEquals(5, question3.size());
        assertEquals(Integer.valueOf(105), question3.pop());
        assertEquals(1, question3.getNumberOfStacks());
        assertEquals(4, question3.size());
        assertEquals(Integer.valueOf(13), question3.pop());
        assertEquals(1, question3.getNumberOfStacks());
        assertEquals(3, question3.size());
        assertEquals(Integer.valueOf(-42), question3.pop());
        assertEquals(1, question3.getNumberOfStacks());
        assertEquals(2, question3.size());
        assertEquals(Integer.valueOf(17), question3.pop());
        assertEquals(1, question3.getNumberOfStacks());
        assertEquals(1, question3.size());
        assertEquals(Integer.valueOf(1), question3.pop());
        assertEquals(0, question3.getNumberOfStacks());
        assertEquals(0, question3.size());

        //Add 16 items to question3
        for (int i = 1; i <= 16; ++i) {
            question3.push(i);
            assertEquals(Integer.valueOf(i), question3.peek());
            assertEquals(Math.ceil(i/4.0), question3.getNumberOfStacks());
            assertEquals(i, question3.size());
        }

        //Pop off stack 1 until its removed
        assertEquals(Integer.valueOf(8), question3.popAt(1));
        assertEquals(4, question3.getNumberOfStacks());
        assertEquals(15, question3.size());
        assertEquals(Integer.valueOf(7), question3.popAt(1));
        assertEquals(4, question3.getNumberOfStacks());
        assertEquals(14, question3.size());
        assertEquals(Integer.valueOf(6), question3.popAt(1));
        assertEquals(4, question3.getNumberOfStacks());
        assertEquals(13, question3.size());
        assertEquals(Integer.valueOf(5), question3.popAt(1));
        assertEquals(3, question3.getNumberOfStacks());
        assertEquals(12, question3.size());

    }

}