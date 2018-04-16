package chapter2;

import Helpers.ListNode;

public class Question4 {

    /**
     * Partition
     *
     * @implSpec Write code to partition a linked list around a value x, such that all nodes less than x
     * come before all nodes greater than or equal to x. lf x is contained within the list, the values of x
     * only need to be after the elements less than x (see below).
     * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the
     * left and right partitions.
     *
     * Note: We do not change order of nodes in list, we simply partition them around x.
     * This means multiple valid solutions exist and left/right partitions nodes can be in any order.
     *
     * @implNote Maintain 4 references, head/tail of left and right partition. Then do one pass over list checking the
     * value each iteration. Build each partition as we iterate by adding the current node to lTail or rTail.
     * Finally, make lTail point to rTail and rTail point to null to create the final linked list.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param listNode input singly linked list to partition
     * @param x value to partition on
     * @param <T> Type for value in each node
     * @return paritioned linked list around x
     * @throws IllegalArgumentException null listnode provided
     */
    public static <T extends Comparable> ListNode<T> partition(ListNode<T> listNode, T x) throws IllegalArgumentException {
        //Fail if given null
        if (listNode == null)
            throw new IllegalArgumentException("Null ListNode provided");
        //Single element case, return node as is
        else if (listNode.next == null)
            return listNode;

        //Maintain 4 references, head/tail of left partition and head/tail of right partition
        ListNode<T> lTail = null, lHead = null;
        ListNode<T> rTail = null, rHead = null;

        //Do one pass over linked list
        while (listNode != null) {
            if (listNode.val.compareTo(x) < 0) {
                //If left tail is null, set tail to first element found less than x
                if (lTail == null) {
                    lTail = listNode;
                    lHead = listNode;
                }
                else {
                    //Make previous left tail point to current node and make current node the new 'previous' node
                    lTail.next = listNode;
                    lTail = listNode;
                }
            }
            else { //>= x
                //If right tail is null, set tail to first element found greater than or equal to x
                if (rTail == null) {
                    rTail = listNode;
                    rHead = listNode;
                }
                else {
                    //Make previous right tail point to current node and make current node the new 'previous' node
                    rTail.next = listNode;
                    rTail = listNode;
                }
            }

            //Move to next node
            listNode = listNode.next;
        }

        //Finally, ensure end of right partition points to null
        //And link tail of left partition to head of right partition to create the final linked list
        rTail.next = null;
        lTail.next = rHead;

        return lHead;
    }

    /**
     * Partition [EXTERNAL]
     *
     * @implSpec Write code to partition a linked list around a value x, such that all nodes less than x
     * come before all nodes greater than or equal to x. lf x is contained within the list, the values of x
     * only need to be after the elements less than x (see below).
     * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the
     * left and right partitions.
     *
     * Note: We do not change order of nodes in list, we simply partition them around x.
     * This means multiple valid solutions exist and left/right partitions nodes can be in any order.
     *
     * @implNote Use two node references to grow the list at the head and tail (as we do not care about the order
     * of the elements in the list).
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param listNode input singly linked list to partition
     * @param x value to partition on
     * @param <T> Type for value in each node
     * @return paritioned linked list around x
     * @throws IllegalArgumentException null listnode provided
     */
    public static <T extends Comparable> ListNode<T> partition2(ListNode<T> listNode, T x) throws IllegalArgumentException {
        //Fail if given null
        if (listNode == null)
            throw new IllegalArgumentException("Null ListNode provided");
            //Single element case, return node as is
        else if (listNode.next == null)
            return listNode;

        ListNode<T> head = listNode;
        ListNode<T> tail = listNode;

        while (listNode != null) {
            ListNode<T> next = listNode.next;

            if (listNode.val.compareTo(x) < 0) {
                listNode.next = head;
                head = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }

            listNode = next;
        }

        tail.next = null;

        return head;
    }
}
