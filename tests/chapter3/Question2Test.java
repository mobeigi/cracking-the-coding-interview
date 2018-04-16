package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question2Test {

    @Test
    void stackMin() {
        Question2 question2 = new Question2();

        //Push check
        question2.push(3);
        assertEquals(3, question2.min());
        question2.push(2);
        assertEquals(2, question2.min());
        question2.push(17);
        assertEquals(2, question2.min());
        question2.push(1);
        assertEquals(1, question2.min());
        question2.push(4);
        assertEquals(1, question2.min());
        question2.push(0);
        assertEquals(0, question2.min());
        question2.push(8);
        assertEquals(0, question2.min());
        question2.push(10);
        assertEquals(0, question2.min());
        question2.push(0);
        assertEquals(0, question2.min());

        //Pops
        question2.pop();
        assertEquals(0, question2.min());
        question2.pop();
        assertEquals(0, question2.min());
        question2.pop();
        assertEquals(0, question2.min());
        question2.pop();
        assertEquals(1, question2.min());
        question2.pop();
        assertEquals(1, question2.min());
        question2.pop();
        assertEquals(2, question2.min());
        question2.pop();
        assertEquals(2, question2.min());
        question2.pop();
        assertEquals(3, question2.min());
        question2.pop();
    }
}