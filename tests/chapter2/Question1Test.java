package chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question1Test {

    public interface Question1Interface {
        <T> ListNode<T> removeDupes(ListNode<T> listNode);
    }

    @Test
    void removeDupes() {
        removeDupesTests(Question1::removeDupes);
    }

    @Test
    void removeDupes2() {
        removeDupesTests(Question1::removeDupes2);
    }

    void removeDupesTests(Question1Interface question1Interface) {

        assertEquals(ListNode.createFromList(Arrays.asList(new Integer[]{})),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(new Integer[]{}))));

        assertEquals(ListNode.createFromList(Arrays.asList(1, 2, 3)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(1, 2, 3, 1, 2, 3))));

        assertEquals(ListNode.createFromList(Arrays.asList(1, 2, 3)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(1, 2, 3, 1, 2, 3, 2, 3, 3, 1, 2, 3, 2, 2, 3, 1, 2, 3, 1, 1, 1, 2, 3))));

        assertEquals(ListNode.createFromList(Arrays.asList(50,-5,77,205)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(50,50,50,-5,-5,77,77,77,77,77,205,50,-5))));

        assertEquals(ListNode.createFromList(Arrays.asList(0)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))));

        assertEquals(ListNode.createFromList(Arrays.asList(5,9,-100,526,461,0,984,11,650,6561354,-9813)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(5,9,-100,526,461,0,984,11,650,6561354,-9813))));

        assertEquals(ListNode.createFromList(Arrays.asList(1)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(1,1))));

        assertEquals(ListNode.createFromList(Arrays.asList(45,46,47,48,49,50,51,52,53)),
                question1Interface.removeDupes(ListNode.createFromList(Arrays.asList(45,46,47,48,49,50,51,51,52,50,53))));
    }
}