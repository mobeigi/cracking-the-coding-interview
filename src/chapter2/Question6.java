package chapter2;

import Helpers.ListNode;

import java.util.HashMap;

public class Question6 {

    /**
     * Palindrome
     *
     * @implSpec Checks if singly linked list is a palindrome.
     *
     * @implNote Get length of list and mid node, and for each node in first half, use runner to check
     * corresponding node
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param listNode input singly linked list
     * @param <T> Type for value in each node
     * @return true if linked list forms palindrome, false otherwise
     * @throws IllegalArgumentException if listnode is null
     */
    public static <T> boolean isPalindrome(ListNode<T> listNode) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("ListNode provided is null");

        //Get length of list
        int listNodeLength = listNode.length();

        //Get midpoint node reference
        ListNode<T> midpoint = listNode;
        for (int i = 0; i < listNodeLength/2; ++i) {
            midpoint = midpoint.next;
        }

        //Check each node in first half of linked list
        ListNode<T> tmp = listNode;
        for (int i = 0; i < listNodeLength/2; ++i) {
            //Create runner and run to corresponding position
            ListNode<T> midpointRunner = midpoint;

            for (int j = 0; j < Math.ceil(listNodeLength/2.0)-1-i; ++j) {
                midpointRunner = midpointRunner.next;
            }

            //Not palindrome if values differ
            if (midpointRunner.val != tmp.val)
                return false;

            tmp = tmp.next;
        }

        return true;
    }

    /**
     * Palindrome
     *
     * @implSpec Checks if singly linked list is a palindrome.
     *
     * @implNote Generate map of index -> node references, for each node in first half, check corresponding node
     * value in map
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param listNode input singly linked list
     * @param <T> Type for value in each node
     * @return true if linked list forms palindrome, false otherwise
     * @throws IllegalArgumentException if listnode is null
     */
    public static <T> boolean isPalindrome2(ListNode<T> listNode) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("ListNode provided is null");

        HashMap<Integer, ListNode<T>> valMap = new HashMap<>();

        //Generate map of index -> ListNode references
        ListNode<T> tmp = listNode;
        int listNodeLength = 0;

        while (tmp != null) {
            valMap.put(listNodeLength, tmp);
            ++listNodeLength;
            tmp = tmp.next;
        }

        //Check each node in first half of linked list
        for (int i = 0; i < listNodeLength/2; ++i) {
            if (valMap.get(i).val != valMap.get(listNodeLength-1-i).val)
                return false;
        }

        return true;
    }

    /**
     * Palindrome [EXTERNAL]
     *
     * @implSpec Checks if singly linked list is a palindrome.
     *
     * @implNote Get length of list and mid node, reverse 2nd half of list then ensure first half and second half
     * of list are the same.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param listNode input singly linked list
     * @param <T> Type for value in each node
     * @return true if linked list forms palindrome, false otherwise
     * @throws IllegalArgumentException if listnode is null
     */
    public static <T> boolean isPalindrome3(ListNode<T> listNode) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("ListNode provided is null");

        //Get length of list
        int listNodeLength = listNode.length();

        //Get midpoint node reference
        //We want the node prior to the actual midpoint so we can set its 'next' reference
        ListNode<T> midpoint = listNode;
        for (int i = 0; i < Math.ceil(listNodeLength/2.0)-1; ++i) {
            midpoint = midpoint.next;
        }

        //Reverse list from mid point to end of list
        midpoint.next = ListNode.reverse(midpoint.next);

        //Check each node in first half of linked list
        //The first and second half of the list should now have the same values due to the above reversal
        ListNode<T> tmp = midpoint.next;
        for (int i = 0; i < listNodeLength/2; ++i) {
            if (listNode.val != tmp.val)
                return false;

            tmp = tmp.next;
            listNode = listNode.next;
        }

        return true;
    }
}
