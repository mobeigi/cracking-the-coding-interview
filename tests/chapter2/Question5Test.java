package chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Question5Test {

    public interface Question5Interface {
        <T extends Number> ListNode<T> sumLists(ListNode<T> l1, ListNode<T> l2);
    }

    @Test
    void sumLists() {
        sumListTests(Question5::sumLists);
    }

    @Test
    void sumLists2() {
        sumListTests(Question5::sumLists2);
    }

    @Test
    void sumLists3() {
        sumListTests(Question5::sumLists3);
    }

    @Test
    void sumLists4() {
        sumListTests(Question5::sumLists4);
    }

    @Test
    void sumListsReverse() {
        sumListReverseTests(Question5::sumListsReverse);
    }


    void sumListTests(Question5Interface question5Interface) {
        //IllegalArgumentException
        //Both null
        assertThrows(IllegalArgumentException.class, () -> question5Interface.sumLists(ListNode.createFromList(Arrays.asList()), ListNode.createFromList(Arrays.asList())));


        //Valid Inputs
        //Provided test case
        assertEquals(ListNode.createFromList(Arrays.asList(9,1,2)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(6,1,7)),
                        ListNode.createFromList(Arrays.asList(2,9,5))));

        //Single digit
        assertEquals(ListNode.createFromList(Arrays.asList(7)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(4)),
                        ListNode.createFromList(Arrays.asList(3))));

        //Double digit
        assertEquals(ListNode.createFromList(Arrays.asList(9,3)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(5,2)),
                        ListNode.createFromList(Arrays.asList(4,1))));

        //Differing lengths
        assertEquals(ListNode.createFromList(Arrays.asList(2,0)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(1,3)),
                        ListNode.createFromList(Arrays.asList(7))));

        assertEquals(ListNode.createFromList(Arrays.asList(6,3,5,3,8)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(6,3,5,1,2)),
                        ListNode.createFromList(Arrays.asList(2,6))));

        //Special case: Final carry
        assertEquals(ListNode.createFromList(Arrays.asList(1,0,0,0,0)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(1)),
                        ListNode.createFromList(Arrays.asList(9,9,9,9))));

        //One List Empty
        assertEquals(ListNode.createFromList(Arrays.asList(7,1,2)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList()),
                        ListNode.createFromList(Arrays.asList(7,1,2))));

        //Overflow test
        assertEquals(ListNode.createFromList(Arrays.asList(2,1,4,7,4,8,3,6,5,0)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(2,1,4,7,4,8,3,6,4,7)),
                        ListNode.createFromList(Arrays.asList(3))));
    }

    void sumListReverseTests(Question5Interface question5Interface) {
        //IllegalArgumentException
        //Both null
        assertThrows(IllegalArgumentException.class, () -> question5Interface.sumLists(ListNode.createFromList(Arrays.asList()), ListNode.createFromList(Arrays.asList())));

        //Provided test case
        assertEquals(ListNode.createFromList(Arrays.asList(2,1,9)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(7,1,6)),
                        ListNode.createFromList(Arrays.asList(5,9,2))));

        //Single digit
        assertEquals(ListNode.createFromList(Arrays.asList(7)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(4)),
                        ListNode.createFromList(Arrays.asList(3))));

        //Double digit
        assertEquals(ListNode.createFromList(Arrays.asList(3,9)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(2,5)),
                        ListNode.createFromList(Arrays.asList(1,4))));

        //Differing lengths
        assertEquals(ListNode.createFromList(Arrays.asList(0,2)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(3,1)),
                        ListNode.createFromList(Arrays.asList(7))));

        assertEquals(ListNode.createFromList(Arrays.asList(8,3,5,3,6)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(2,1,5,3,6)),
                        ListNode.createFromList(Arrays.asList(6,2))));

        //Special case: Final carry
        assertEquals(ListNode.createFromList(Arrays.asList(0,0,0,0,1)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(1)),
                        ListNode.createFromList(Arrays.asList(9,9,9,9))));

        //One List Empty
        assertEquals(ListNode.createFromList(Arrays.asList(2,1,7)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList()),
                        ListNode.createFromList(Arrays.asList(2,1,7))));

        //Overflow test
        assertEquals(ListNode.createFromList(Arrays.asList(0,5,6,3,8,4,7,4,1,2)),
                question5Interface.sumLists(ListNode.createFromList(Arrays.asList(7,4,6,3,8,4,7,4,1,2)),
                        ListNode.createFromList(Arrays.asList(3))));
    }
}