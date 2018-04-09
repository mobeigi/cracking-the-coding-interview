package Chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Question3Test {

    @Test
    void deleteMiddleNode() {
        //IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> Question3.deleteMiddleNode(null));
        assertThrows(IllegalArgumentException.class, () -> Question3.deleteMiddleNode(ListNode.createFromList(Arrays.asList(1))));
        assertThrows(IllegalArgumentException.class, () -> Question3.deleteMiddleNode(ListNode.createFromList(Arrays.asList(-50))));

        //Valid inputs
        //Test vars
        ListNode<Integer> head = null;
        ListNode<Integer> input = null;
        int count = 0, iterCount = 0;

        //Impossible to tell if head so must remove first element 50
        head = ListNode.createFromList(Arrays.asList(50,25));
        input = head;
        count = 0;
        iterCount = 0;
        while (count < iterCount) { input = input.next; ++count;}
        Question3.deleteMiddleNode(input);
        assertEquals(ListNode.createFromList(Arrays.asList(25)), head);

        //Special case: Avoid removing 1st element, Remove 2nd element 0
        head = ListNode.createFromList(Arrays.asList(1,0,1));
        input = head;
        count = 0;
        iterCount = 1;
        while (count < iterCount) { input = input.next; ++count;}
        Question3.deleteMiddleNode(input);
        assertEquals(ListNode.createFromList(Arrays.asList(1,1)), head);

        //Remove 8th element 3
        head = ListNode.createFromList(Arrays.asList(-5,17,2,6,8,1,2,3,-12,0,5));
        input = head;
        count = 0;
        iterCount = 6;
        while (count < iterCount) { input = input.next; ++count;}
        Question3.deleteMiddleNode(input);
        assertEquals(ListNode.createFromList(Arrays.asList(-5,17,2,6,8,1,2,-12,0,5)), head);

    }
}