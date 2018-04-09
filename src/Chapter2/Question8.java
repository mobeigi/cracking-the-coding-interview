package Chapter2;

import Helpers.ListNode;

import java.util.IdentityHashMap;

public class Question8 {

    /**
     * Loop Detection
     *
     * @implSpec Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
     * DEFINITION: Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier
     * node, so as to make a loop in the linked list.
     *
     * @implNote Use identity hash map to store seen nodes and return upon seeing duplicate node.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param listNode input singly linked list
     * @param <T> Type for value in each node
     * @return node that is at beginning of circular list or null if not a circular list
     * @throws IllegalArgumentException if listNode is null
     */
    static <T> ListNode<T> loopDetection(ListNode<T> listNode) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("ListNode provided is null");

        //Dummy boolean used as there is no IdentityHashSet
        IdentityHashMap<ListNode<T>, Boolean> seen = new IdentityHashMap<>();

        while (listNode != null) {
            if (seen.containsKey(listNode))
                return listNode;

            seen.put(listNode, true);
            listNode = listNode.next;
        }

        return null;
    }

    /**
     * Loop Detection [EXTERNAL]
     *
     * @implSpec Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
     * DEFINITION: Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier
     * node, so as to make a loop in the linked list.
     *
     * @implNote Increment slow runner by 1 while incrementing fast runner by 2 from head of the list.
     * Eventually the slow runner and fast runner will collide at LOOP_SIZE - k steps.
     * At this point, set slow to head of list and iterate k times until both slow/fast point to collision node.
     *
     * Time Complexity: O(k+L) {where k is non-loop part of list and L is loop size}
     * Space Complexity: O(1)
     *
     * @param listNode input singly linked list
     * @param <T> Type for value in each node
     * @return node that is at beginning of circular list or null if not a circular list
     * @throws IllegalArgumentException if listNode is null
     */
    static <T> ListNode<T> loopDetection2(ListNode<T> listNode) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("ListNode provided is null");

        //Use slow and fast runners
        ListNode<T> slow = listNode;
        ListNode<T> fast = listNode;

        while (slow != null && fast != null) {
            //Check if no collision
            if (fast.next == null || fast.next.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        //Move slow from head until it equals fast
        //After this, slow and fast both point to collision node
        slow = listNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
