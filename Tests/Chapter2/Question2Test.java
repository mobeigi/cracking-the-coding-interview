package Chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Question2Test {

    public interface Question2Interface {
        <T> T getKthLastElement(ListNode<T> listNode, int k);
    }

    @Test
    void getKthLastElement() {
        getKthLastElementTests(Question2::getKthLastElement);
    }

    @Test
    void getKthLastElement2() {
        getKthLastElementTests(Question2::getKthLastElement2);
    }

    @Test
    void getKthLastElement3() {
        getKthLastElementTests(Question2::getKthLastElement3);
    }

    void getKthLastElementTests(Question2Interface question2Interface) {
        //IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> question2Interface.getKthLastElement(null, 1));
        assertThrows(IllegalArgumentException.class, () -> question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1)), -1));
        assertThrows(IllegalArgumentException.class, () -> question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1)), 2));
        assertThrows(IllegalArgumentException.class, () -> question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1,-5,10)), 4));

        //Valid inputs
        assertEquals(Integer.valueOf(1), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1)), 1));
        assertEquals(Integer.valueOf(1), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1, 50)), 2));
        assertEquals(Integer.valueOf(50), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1, 50)), 1));
        assertEquals(Integer.valueOf(1), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1, 2, 3, 1, 2, 3)), 3));
        assertEquals(Integer.valueOf(1), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(1, 2, 3, 1, 2, 3)), 6));
        assertEquals(Integer.valueOf(-5), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(-50, -49, -20, 20, 55, 102, 65, 10, -5, -12)), 2));
        assertEquals(Integer.valueOf(-50), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(-50, -49, -20, 20, 55, 102, 65, 10, -5, -12)), 10));
        assertEquals(Integer.valueOf(102), question2Interface.getKthLastElement(ListNode.createFromList(Arrays.asList(-50, -49, -20, 20, 55, 102, 65, 10, -5, -12)), 5));
    }
}