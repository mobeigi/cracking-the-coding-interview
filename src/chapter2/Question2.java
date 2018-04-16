package chapter2;

import Helpers.ListNode;

public class Question2 {

    /**
     * Return Kth to Last
     *
     * @implSpec Implement an algorithm to find the kth to last element of a singly linked list.
     *
     * @implNote First iterate once to find length of listNode. Then, iterate from head length-k times to reach
     * desired node and return.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param listNode input linked list
     * @param k index from end of array (kth last element)
     * @param <T> Type for value in each node
     * @return value at kth last node
     * @throws IllegalArgumentException if null listnode provided or k not in [0,listNode length]
     */
    public static <T> T getKthLastElement(ListNode<T> listNode, int k) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("Null ListNode provided");
        if (k < 0)
            throw new IllegalArgumentException("k must be between 0 and length of ListNode");

        //Iterate once to find length of listNode
        int listLength = listNode.length();

        //Ensure k isn't larger than list length
        if (k > listLength)
            throw new IllegalArgumentException("k must be between 0 and length of ListNode");

        //Iterate from head to desired element at listLength-k
        for (int i = 0; i < listLength - k; ++i) {
            listNode = listNode.next;
        }

        return listNode.val;
    }

    /**
     * Return Kth to Last [EXTERNAL]
     *
     * @implSpec Implement an algorithm to find the kth to last element of a singly linked list.
     *
     * @implNote Maintain two references cur and runner. Traverse list until runner points to kth element.
     * Then traverse both lists together until runner hits last element at which point cur points to the kth last
     * element.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param listNode input linked list
     * @param k index from end of array (kth last element)
     * @param <T> Type for value in each node
     * @return value at kth last node
     * @throws IllegalArgumentException if null listnode provided or k not in [0,listNode length]
     */
    public static <T> T getKthLastElement2(ListNode<T> listNode, int k) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("Null ListNode provided");
        if (k < 0)
            throw new IllegalArgumentException("k must be between 0 and length of ListNode");

        //Iterate runner to kth position
        ListNode<T> cur = listNode;
        ListNode<T> runner = listNode;

        for (int i = 0; i < k-1; ++i) {
            runner = runner.next;
            if (runner == null)
                throw new IllegalArgumentException("k must be between 0 and length of ListNode");
        }

        //Cur and runner are now k positions apart, traverse both lists until runner hits last element in list
        //At which point cur points to kth last element
        while (runner.next != null) {
            runner = runner.next;
            cur = cur.next;
        }

        return cur.val;
    }

    /**
     * Return Kth to Last [EXTERNAL]
     *
     * @implSpec Implement an algorithm to find the kth to last element of a singly linked list.
     *
     * @implNote Recursive solution. Maintain a mutable index which starts from 0 at end of array. Once index equals
     * k, we have the node we need (kth last node). Bounce up that node and return its value.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param listNode input linked list
     * @param k index from end of array (kth last element)
     * @param <T> Type for value in each node
     * @return value at kth last node
     * @throws IllegalArgumentException if null listnode provided or k not in [0,listNode length]
     */
    public static <T> T getKthLastElement3(ListNode<T> listNode, int k) throws IllegalArgumentException {
        if (listNode == null)
            throw new IllegalArgumentException("Null ListNode provided");
        if (k < 0)
            throw new IllegalArgumentException("k must be between 0 and length of ListNode");

        //Create index and call recursive method
        Index index = new Index();
        ListNode<T> result = _getKthLastElement3(listNode, k, index);

        //Null result means k was out of bounds
        if (result == null)
            throw new IllegalArgumentException("k must be between 0 and length of ListNode");

        return result.val;
    }

    /**
     * Mutable wrapper over int
     */
    static class Index {
        public int value = 0;
    }

    /**
     * @see Question2#getKthLastElement3(ListNode, int)
     *
     * @param cur input linked list
     * @param k index from end of array (kth last element)
     * @param index Index wrapper over int (to provide mutable object)
     * @param <T> Type for value in each node
     * @return kth last node or null if k was out of bounds
     */
    private static <T> ListNode<T> _getKthLastElement3(ListNode<T> cur, int k, Index index) {
        if (cur == null)
            return null;

        //Recursive call with next node
        ListNode<T> targetNode = _getKthLastElement3(cur.next, k, index);
        index.value += 1;

        //If index == k, return cur which will be bounced up call stack
        if (index.value == k)
            return cur;

        return targetNode;
    }
}
