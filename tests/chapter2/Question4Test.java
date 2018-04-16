package chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question4Test {

    public interface Question4Interface {
        <T extends Comparable> ListNode<T> partition(ListNode<T> listNode, T x);
    }

    @Test
    void partition() {
       partitionTests(Question4::partition);
    }

    @Test
    void partition2() {
        partitionTests(Question4::partition2);
    }

    void partitionTests(Question4Interface question4Interface) {
        //IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> question4Interface.partition(null, 1));

        //Valid inputs

        //Test vars
        ListNode<Integer> origListNode;
        ListNode<Integer> partitionedListNode;
        int x = 0;

        //Provided test case
        origListNode = ListNode.createFromList(Arrays.asList(3,5,8,5,10,2,1));
        partitionedListNode = new ListNode<Integer>(origListNode);
        x = 5;
        partitionedListNode = question4Interface.partition(partitionedListNode, x);
        assertTrue(confirmValidPartition(partitionedListNode, x));
        assertTrue(hasSameFrequency(origListNode, partitionedListNode));

        //Single node
        origListNode = ListNode.createFromList(Arrays.asList(100));
        partitionedListNode = new ListNode<Integer>(origListNode);
        x = 2;
        partitionedListNode = question4Interface.partition(partitionedListNode, x);
        assertTrue(confirmValidPartition(partitionedListNode, x));
        assertTrue(hasSameFrequency(origListNode, partitionedListNode));

        //Two node
        origListNode = ListNode.createFromList(Arrays.asList(26,17));
        partitionedListNode = new ListNode<Integer>(origListNode);
        x = 26;
        partitionedListNode = question4Interface.partition(partitionedListNode, x);
        assertTrue(confirmValidPartition(partitionedListNode, x));
        assertTrue(hasSameFrequency(origListNode, partitionedListNode));

        //X not within set
        origListNode = ListNode.createFromList(Arrays.asList(-1,17,2,14,100,3,12));
        partitionedListNode = new ListNode<Integer>(origListNode);
        x = 15;
        partitionedListNode = question4Interface.partition(partitionedListNode, x);
        assertTrue(confirmValidPartition(partitionedListNode, x));
        assertTrue(hasSameFrequency(origListNode, partitionedListNode));

        //Larger set
        origListNode = ListNode.createFromList(Arrays.asList(40,12,54,10,-2,102,17,65,10));
        partitionedListNode = new ListNode<Integer>(origListNode);
        x = 20;
        partitionedListNode = question4Interface.partition(partitionedListNode, x);
        assertTrue(confirmValidPartition(partitionedListNode, x));
        assertTrue(hasSameFrequency(origListNode, partitionedListNode));
    }

    /**
     * Helper method to confirm partition is valid.
     * Partition is correct if linked list is less than x until first element that is larger than x,
     * after which it must be larger or equal to x.
     *
     * @param listNode sinlgy linked list to check
     * @param x partition value
     * @return true if valid partition and false otherwise
     */
    private boolean confirmValidPartition(ListNode<Integer> listNode, int x) {
        boolean checkLeftParition = true;
        while (listNode != null) {
            if (listNode.val < x && !checkLeftParition) {
                return false;
            }
            else if (listNode.val >= x) {
                checkLeftParition = false;
            }

            listNode = listNode.next;
        }

        return true;
    }

    /**
     * Ensures two linked lists have same number frequency (same nodes with same values but in any order)
     *
     * @param l1 first list
     * @param l2 second list
     * @return true if same frequency and false otherwise
     */
    private boolean hasSameFrequency(ListNode<Integer> l1, ListNode<Integer> l2) {
        HashMap<Integer, Integer> l1Freq = new HashMap<>();
        HashMap<Integer, Integer> l2Freq = new HashMap<>();

        while (l1 != null) {
            l1Freq.put(l1.val, l1Freq.getOrDefault(l1.val, 0) + 1);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Freq.put(l2.val, l2Freq.getOrDefault(l2.val, 0) + 1);
            l2 = l2.next;
        }

        return l1Freq.equals(l2Freq);
    }
}