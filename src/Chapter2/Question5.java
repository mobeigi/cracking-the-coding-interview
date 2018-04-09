package Chapter2;

import Helpers.ListNode;

import java.util.HashSet;

public class Question5 {

    /**
     * Sum Lists
     *
     * @implSpec You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in forward order, such that the 1's digit is at the end of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * @implNote Reverse both input lists and delegate to sumListsReverse.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return new list of summed nodes
     * @throws IllegalArgumentException if both listnodes provided are null
     */
    public static <T extends Number> ListNode<T> sumLists(ListNode<T> l1, ListNode<T> l2) throws IllegalArgumentException {
        if (l1 == null && l2 == null)
            throw new IllegalArgumentException("Both ListNode provided are null");

        ListNode<T> l1Reverse = ListNode.reverse(l1);
        ListNode<T> l2Reverse = ListNode.reverse(l2);
        return ListNode.reverse(sumListsReverse(l1Reverse, l2Reverse));
    }

    /**
     * Sum Lists
     *
     * @implSpec You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in forward order, such that the 1's digit is at the end of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * @implNote Parse both input lists as integers, sum them, then turn that into a result list (overflow prone!).
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return new list of summed nodes
     * @throws IllegalArgumentException if both listnodes provided are null
     */
    public static <T extends Number> ListNode<T> sumLists2(ListNode<T> l1, ListNode<T> l2) throws IllegalArgumentException {
        if (l1 == null && l2 == null)
            throw new IllegalArgumentException("Both ListNode provided are null");

        long l1TotalVal = 0, l2TotalVal = 0;

        //Get l1 value as int
        while (l1 != null) {
            l1TotalVal *= 10;
            l1TotalVal += l1.val.longValue();

            l1 = l1.next;
        }

        //Get l2 value as int
        while (l2 != null) {
            l2TotalVal *= 10;
            l2TotalVal += l2.val.longValue();

            l2 = l2.next;
        }

        //Turn result into linked list
        ListNode<T> cur = null, prev = null;
        long sum = l1TotalVal + l2TotalVal;

        while (sum > 0) {
            Integer digit = (int)(sum % 10); //cast result to int
            sum /= 10;

            cur = new ListNode<T>((T)digit);
            cur.next = prev;
            prev = cur;
        }

        return prev;
    }

    /**
     * Sum Lists
     *
     * @implSpec You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in forward order, such that the 1's digit is at the end of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * @implNote Get length of both lists via two iterations.
     * Then, create resultant link list upto difference between lists.
     * Then, 1st Pass: for remainder of both lists (which are now aligned), add digits % 10 without resolving carries.
     * Carries are however stored in a set marking the prior index.
     * Finally, 2nd pass: iterate over resultant list and resolve all carries using a lookahead approach.
     * Handle final special case of adding an extra (1) node to front of list.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return new list of summed nodes
     * @throws IllegalArgumentException if both listnodes provided are null
     */
    public static <T extends Number> ListNode<T> sumLists3(ListNode<T> l1, ListNode<T> l2) throws IllegalArgumentException {
        if (l1 == null && l2 == null)
            throw new IllegalArgumentException("Both ListNode provided are null");

        ListNode<T> res = null, resHead = null;

        int l1Length = 0, l2Length = 0;

        if (l1 != null)
            l1Length = l1.length();
        if (l2 != null)
            l2Length = l2.length();

        //Do first pass over adding digits

        //Set tmp to longer list
        //Iterate longer list until it reaches most significant digit of shorter list (i.e. they are aligned)
        ListNode<T> tmp = (l1Length > l2Length ? l1 : l2);
        int index = 0;

        while (tmp != null && index < Math.abs(l1Length-l2Length)) {
            //Set result node value
            if (res == null) {
                res = resHead = new ListNode<T>(tmp.val);
            }
            else {
                res.next = new ListNode<>(tmp.val);
                res = res.next;
            }

            tmp = tmp.next;
            ++index;
        }

        if (l1Length > l2Length)
            l1 = tmp;
        else
            l2 = tmp;

        //1st Pass: Add digits without resolving carry
        //Iterate while either l1 or l2 is not null
        HashSet<Integer> carrySet = new HashSet<>();

        while (l1 != null || l2 != null) {
            //Get values of l1/l2 or default to 0 if one list has reached its end
            int l1Val = (l1 != null ? l1.val.intValue() : 0);
            int l2Val = (l2 != null ? l2.val.intValue() : 0);

            //Compute sum and carry
            int sum = l1Val + l2Val;
            int carry = (sum >= 10 ? 1 : 0);

            //Story carry in carry set
            if (carry == 1)
                carrySet.add(index-1);

            //Increment counter
            ++index;

            //Set result node value
            if (res == null) {
                res = resHead = new ListNode<>((T)Integer.valueOf(sum % 10));
            }
            else {
                res.next = new ListNode<>((T)Integer.valueOf(sum % 10));
                res = res.next;
            }

            //Progress list
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        //2nd pass: Resolve carries
        res = resHead;
        index = 0;

        while (res != null) {
            int value = res.val.intValue();

            if (carrySet.contains(index))
                value += 1;

            //Look ahead for carries
            ListNode<Integer> lookahead = res.next;
            int lookaheadIndex = index + 1;
            while (lookahead != null) {
                if (lookahead.val == 9 && carrySet.contains(lookaheadIndex)) {
                    value += 1;
                    break;
                }
                if (lookahead.val != 9)
                    break;

                lookahead = lookahead.next;
                ++lookaheadIndex;
            }

            //Set carry for previous index (to handle special case)
            if (value >= 10)
                carrySet.add(index-1);

            //Set final value
            res.val = (T)Integer.valueOf(value % 10);

            res = res.next;
            ++index;
        }

        //Special Case: Extra node at front
        if (carrySet.contains(-1)) {
            res = resHead;
            resHead = new ListNode<>((T)Integer.valueOf(1));
            resHead.next = res;
        }

        return resHead;
    }

    /**
     * Sum Lists [EXTERNAL]
     *
     * @implSpec You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in forward order, such that the 1's digit is at the end of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * @implNote Recursive solution. From end of list, bubble carry upwards and create linked list in reverse order.
     * Finally, handle special case of final carry and return resultant list.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return new list of summed nodes
     * @throws IllegalArgumentException if both listnodes provided are null
     */
    public static <T extends Number> ListNode<T> sumLists4(ListNode<T> l1, ListNode<T> l2) throws IllegalArgumentException {
        if (l1 == null && l2 == null)
            throw new IllegalArgumentException("Both ListNode provided are null");

        ListNode<T> res = null, resHead = null;

        int l1Length = 0, l2Length = 0;
        if (l1 != null)
            l1Length = l1.length();
        if (l2 != null)
            l2Length = l2.length();

        //Pad shorter list with zeros
        ListNode<T> tmp = (l1Length < l2Length) ? l1 : l2;

        for (int i = 0; i < Math.abs(l1Length-l2Length); ++i) {
            ListNode<T> newNode = new ListNode<T>((T)Integer.valueOf(0));
            newNode.next = tmp;
            tmp = newNode;
        }

        if (l1Length < l2Length)
            l1 = tmp;
        else
            l2 = tmp;

        //Call recursive method
        Carry carry = new Carry();
        ListNode<T> result = _sumLists4(l1, l2, carry);

        //Handle final carry special case
        if (carry.value == 1) {
            ListNode<T> head = new ListNode<T>((T)Integer.valueOf(1));
            head.next = result;
            result = head;
        }
        return result;
    }

    /**
     * Mutable wrapper over int
     */
    static class Carry {
        public int value = 0;
    }

    /**
     * @see Question5#sumLists4(ListNode, ListNode)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return new list of summed nodes
     */
    private static <T extends Number> ListNode<T> _sumLists4(ListNode<T> l1, ListNode<T> l2, Carry carry) {
        //Base case (end of both lists)
        if (l1 == null && l2 == null)
            return null;

        //Get previous node (down call stack)
        ListNode<T> prev = _sumLists4(l1.next, l2.next, carry);

        int sum = l1.val.intValue() + l2.val.intValue() + carry.value;
        carry.value = (sum >= 10) ? 1 : 0;
        ListNode<T> cur = new ListNode<>((T)Integer.valueOf(sum % 10));
        cur.next = prev;

        return cur;
    }


    /**
     * Sum Lists Reverse
     *
     * @implSpec You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     *
     * @implNote Simply traverse both lists together, calculating sum and carry (for next iteration) and create
     * resultant list as you go. Also handle final carry as a special case.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param l1 first singly linked list
     * @param l2 second singly linked list
     * @param <T> Type for value in each node
     * @return new list of summed nodes
     * @throws IllegalArgumentException if both listnodes provided are null
     */
    public static <T extends Number> ListNode<T> sumListsReverse(ListNode<T> l1, ListNode<T> l2) throws IllegalArgumentException {
        if (l1 == null && l2 == null)
            throw new IllegalArgumentException("Both ListNode provided are null");

        ListNode<T> res = null, resHead = null;
        int carry = 0;

        //Iterate while either l1 or l2 is not null
        while (l1 != null || l2 != null) {
            //Get values of l1/l2 or default to 0 if one list has reached its end
            Integer l1Val = (l1 != null ? l1.val.intValue() : 0);
            Integer l2Val = (l2 != null ? l2.val.intValue() : 0);

            //Compute sum and carry
            int sum = l1Val + l2Val + carry;
            carry = (sum >= 10 ? 1 : 0);

            //Set result node value
            if (res == null) {
                res = resHead = new ListNode<>((T)Integer.valueOf(sum % 10));
            }
            else {
                res.next = new ListNode<>((T)Integer.valueOf(sum % 10));
                res = res.next;
            }

            //Progress list
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        //Handle final carry
        if (carry == 1)
            res.next = new ListNode<>(1);

        return resHead;
    }
}
