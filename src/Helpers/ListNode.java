package Helpers;

import java.util.List;

/**
 * Definition for singly-linked list.
 *
 * @param <T> Type for value in each node
 */
public class ListNode<T> {
    public T val;
    public ListNode next;

    /*
    * Constructors
    */
    public ListNode() { this.val = null; }
    public ListNode(T val) {
        this.val = val;
    }

    //Copy constructor
    public ListNode(ListNode<T> source) {
        this.val = source.val;
        if(source.next != null) {
            this.next = new ListNode<T>(source.next);
        }
    }

    /*
     * Instance methods
     */
    public int length() {
        ListNode<T> tmp = (ListNode<T>) this;
        int count = 0;
        while (tmp != null) {
            ++count;
            tmp = tmp.next;
        }
        return count;
    }

    /*
     * Static Methods/Helpers
     */

    /**
     * Create singly-linked list from a list
     *
     * @param list input list
     * @return singly-linked list with all values in list or null if empty list provided
     */
    public static <T> ListNode<T> createFromList(List<T> list) {
        if (list.isEmpty())
            return null;

        ListNode<T> head = new ListNode<>();
        ListNode<T> cur = head;

        for (int i = 0; i < list.size(); ++i) {
            cur.val = list.get(i);

            //Create next node if not last iteration
            if (i != list.size()-1) {
                cur.next = new ListNode<T>();
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * Print List Node as string to stdout
     * -> indicates singly link
     * X indicates NULL value
     */
    public static <T> void print(ListNode<T> listNode) {
        StringBuilder sb = new StringBuilder();

        while(listNode != null) {
            sb.append(listNode.val).append("->");
            listNode = listNode.next;
        }
        sb.append("X"); //final null

        System.out.println(sb.toString());
    }

    /**
     * Reverse input list
     *
     * @param listNode list to reverse
     * @param <T> Type for value in each node
     * @return reversed linked list
     */
    public static <T> ListNode<T> reverse(ListNode<T> listNode){
        ListNode<T> listNodeReverse = null;

        //Reverse l1
        while (listNode != null) {
            ListNode<T> tmpPrev = listNodeReverse;
            listNodeReverse = new ListNode<>(listNode.val);
            listNodeReverse.next = tmpPrev;

            listNode = listNode.next;
        }

        return listNodeReverse;
    }

    /*
     * Overrides
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode<?> l1 = this;
        ListNode<?> l2 = (ListNode<?>) o;

        while (l1 != null || l2 != null) {
            if (l1 == null)
                return false;
            if (l2 == null)
                return false;
            if (!l1.val.equals(l2.val))
                return false;

            //Advance nodes
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        ListNode<?> l1 = this;
        while (l1 != null) {
            hash += (Integer)l1.val * (Integer)l1.val;
            l1 = l1.next;
        }

        return hash;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}