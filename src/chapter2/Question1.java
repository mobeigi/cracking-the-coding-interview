package chapter2;

import Helpers.ListNode;

import java.util.HashSet;

public class Question1 {

    /**
     * Remove Dups
     *
     * @implSpec Write code to remove duplicates from an unsorted linked list.
     *
     * @implNote Use a hashset to store node values seen so far. If duplicate found, use a prev node reference
     * to skip the cur node.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param listNode input linked list
     * @param <T> Type for value in each node
     * @return linkedList with all duplicates removed
     */
    public static <T> ListNode<T> removeDupes(ListNode<T> listNode) {
        HashSet<T> seen = new HashSet<>();

        //Maintain current and previous nodes
        ListNode<T> cur = listNode;
        ListNode<T> prev = listNode;

        while (cur != null) {
            if (seen.contains(cur.val)) {
                prev.next = cur.next;
                cur = prev.next;
            }
            else {
                seen.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }

        return listNode;
    }

    /**
     * Remove Dups
     *
     * @implSpec Write code to remove duplicates from an unsorted linked list.
     * Temporary buffer is not allowed.
     *
     * @implNote For each node, remove all duplicates in remainder of list using a runner.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param listNode input linked list
     * @param <T> Type for value in each node
     * @return linkedList with all duplicates removed
     */
    public static <T> ListNode<T> removeDupes2(ListNode<T> listNode) {
        //Maintain current node
        ListNode<T> cur = listNode;

        while (cur != null) {
            //Remove all occurrences of this value from rest of list
            ListNode<T> runner = cur;

            while (runner.next != null) {
                if (runner.next.val.equals(cur.val))
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }

            cur = cur.next;
        }

        return listNode;
    }
}
