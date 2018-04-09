package Chapter2;

import Helpers.ListNode;

import java.util.IdentityHashMap;

public class Question7 {

    /**
     * Intersection
     *
     * @implSpec Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
     * node. Note that the intersection is defined based on reference, not value. That is, if the kth
     * node of the first linked list is the exact same node (by reference) as the jth node of the second
     * linked list, then they are intersecting.
     *
     * @implNote Get length of both lists. Then iterate iterate longer list until both lists are 'aligned'.
     * Finally, iterate remainder of list checking for same object reference.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return intersecting node if intersection exists, null otherwise
     */
    public static <T> ListNode<T> intersection(ListNode<T> l1, ListNode<T> l2) {
        if (l1 == null || l2 == null)
            return null;

        //Get length of both lists
        int l1Length = l1.length();
        int l2Length = l2.length();

        //Iterate longer list until both lists 'aligned'
        for (int i = 0; i < Math.abs(l1Length-l2Length); ++i) {
            if (l1Length > l2Length)
                l1 = l1.next;
            else
                l2 = l2.next;
        }

        while (l1 != null) {
            if (l1 == l2) { //reference check
                return l1;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }

    /**
     * Intersection
     *
     * @implSpec Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
     * node. Note that the intersection is defined based on reference, not value. That is, if the kth
     * node of the first linked list is the exact same node (by reference) as the jth node of the second
     * linked list, then they are intersecting.
     *
     * @implNote Store each reference in first list in an identity hashmap (acting like a set). Then iterate over
     * second list and if we see a reference that has been seen already, we return that intersecting node.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return intersecting node if intersection exists, null otherwise
     */
    public static <T> ListNode<T> intersection2(ListNode<T> l1, ListNode<T> l2) {
            if (l1 == null || l2 == null)
                return null;

            //Dummy boolean used as there is no IdentityHashSet
            IdentityHashMap<ListNode<T>, Boolean> seen = new IdentityHashMap<ListNode<T>, Boolean>();

            //Add all references to map from l1
            while (l1 != null) {
                seen.put(l1, true);
                l1 = l1.next;
            }

            //Check if l2 contains any l1 references
            while (l2 != null) {
                if (seen.containsKey(l2))
                    return l2;

                l2 = l2.next;
            }

            return null;
    }
}
