package Chapter2;

import Helpers.ListNode;

public class Question3 {

    /**
     * Delete Middle Node
     *
     * @implSpec Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
     * not necessarily the exact middle) of a singly linked list, given only access to that node.
     *
     * @implNote Copy the value of the next node and then skip the next node. Note: We must also check the special case
     * of potentially removing the first node.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param listNode singly linked list to delete middle node from
     * @param <T> Type for value in each node
     * @throws IllegalArgumentException null listnode or last listnode provided
     */
    public static <T> void deleteMiddleNode(ListNode<T> listNode) throws IllegalArgumentException {
        //Fail if given null or last node
        if (listNode == null)
            throw new IllegalArgumentException("Null ListNode provided");
        else if (listNode.next == null)
            throw new IllegalArgumentException("Last ListNode provided");

        //Special case: Avoid removing first node
        //If given head of list, we can work on the next node if we know the next node is not the tail of the list
        //This allows us to avoid potentially replacing the head of list
        if (listNode.next.next != null)
            listNode = listNode.next;

        //Copy next nodes value and remove next node from linked list
        listNode.val = (T)listNode.next.val;
        listNode.next = listNode.next.next;
    }
}
