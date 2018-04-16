package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question1Test {

    @Test
    void threeInOneTest() {
        try {
            //Class supporting 3 stacks
            Question1 question1 = new Question1(3);

            assertTrue(question1.isEmpty(0));
            assertTrue(question1.isEmpty(1));
            assertTrue(question1.isEmpty(2));

            //0: 10->X
            //1: 10->X
            //2: 10->X
            question1.push(0, 10);
            question1.push(1, 10);
            question1.push(2, 10);
            assertEquals(10, question1.peek(0));
            assertEquals(10, question1.peek(1));
            assertEquals(10, question1.peek(2));

            //0: X
            //1: X
            //2: 10->20->X
            assertEquals(10, question1.pop(0));
            assertEquals(10, question1.pop(1));
            assertTrue(question1.isEmpty(0));
            assertTrue(question1.isEmpty(1));
            question1.push(2, 20);
            assertEquals(20, question1.peek(2));

            //Add 100 elements to 0
            for (int i = 0; i < 100; ++i) {
                question1.push(0, i);
                assertEquals(i, question1.peek(0));
            }
            //Pop 100 elements from 0
            for (int i = 99; i >= 0; --i) {
                assertEquals(i, question1.pop(0));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("Exception encountered");
        }
    }
}