package chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class Question7Test {
    private interface Question7Interface {
        <T> ListNode<T> intersection(ListNode<T> l1, ListNode<T> l2);
    }

    @Test
    void intersection() {
        intersectionTest(Question7::intersection);
    }

    @Test
    void intersection2() {
        intersectionTest(Question7::intersection2);
    }

    //Generic test
    private void intersectionTest(Question7Interface question7Interface) {
        //Variables
        ListNode<Integer> first, second, tmp, tmp2;

        //Not intersecting (null)

        //Both null
        first = ListNode.createFromList(Arrays.asList());
        second = ListNode.createFromList(Arrays.asList());
        assertNull(question7Interface.intersection(first, second));
        assertNull(question7Interface.intersection(second, first));

        //One null
        first = ListNode.createFromList(Arrays.asList());
        second = ListNode.createFromList(Arrays.asList(5,6,8,1,5));
        assertNull(question7Interface.intersection(first, second));
        assertNull(question7Interface.intersection(second, first));

        //Same equals value
        first = ListNode.createFromList(Arrays.asList(5));
        second = ListNode.createFromList(Arrays.asList(5));
        assertNull(question7Interface.intersection(first, second));
        assertNull(question7Interface.intersection(second, first));

        //Different length
        first = ListNode.createFromList(Arrays.asList(5,5));
        second = ListNode.createFromList(Arrays.asList(5,5,5,5,5,5,5,5,5,5,5,5));
        assertNull(question7Interface.intersection(first, second));
        assertNull(question7Interface.intersection(second, first));

        //Random
        first = ListNode.createFromList(Arrays.asList(6,17,5,2,5,6,81,6,8,4,13,56,1));
        second = ListNode.createFromList(Arrays.asList(19,5,6,3,4,5,6,1,2,8,4,6,3,5,1,6,8,10,56));
        assertNull(question7Interface.intersection(first, second));
        assertNull(question7Interface.intersection(second, first));

        //Intersecting

        //Intersect at end (end of first points to second so head of second is intersecting node).
        first = ListNode.createFromList(Arrays.asList(1,2,3));
        second = ListNode.createFromList(Arrays.asList(5,6,7));
        tmp = first;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = second;
        assertSame(second, question7Interface.intersection(first, second));
        assertSame(second, question7Interface.intersection(second, first));

        //Single element list
        first = ListNode.createFromList(Arrays.asList(100));
        second = first;
        assertSame(first, question7Interface.intersection(first, second));
        assertSame(first, question7Interface.intersection(second, first));
        assertSame(second, question7Interface.intersection(first, second));
        assertSame(second, question7Interface.intersection(second, first));

        //Two identical lists
        first = ListNode.createFromList(Arrays.asList(7,5,8,-2));
        assertSame(first, question7Interface.intersection(first, first));

        //Two identical lists from mid-way
        first = ListNode.createFromList(Arrays.asList(3,4,2));
        second = ListNode.createFromList(Arrays.asList(9,5,1,6,1,48,50,-50,23));
        tmp = ListNode.createFromList(Arrays.asList(7,5,8,-2));

        tmp2 = first;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp;


        tmp2 = second;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp;

        assertSame(tmp, question7Interface.intersection(first, second));
        assertSame(tmp, question7Interface.intersection(second, first));

        //One long list, one short list
        first = ListNode.createFromList(Arrays.asList(1,5));
        second = ListNode.createFromList(Arrays.asList(62,29,6,1,5,6,2,55,8,1,57,3,6,9,8,4,1,50,65,21,5,4,1,56,3,4,1,96,21,2,6,8,4,23,5,4,5,6,1,3,5,89,1,2));
        tmp = ListNode.createFromList(Arrays.asList(19,5,15,36,20,65,21,63,41,25,62));

        tmp2 = first;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp;


        tmp2 = second;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp;

        assertSame(tmp, question7Interface.intersection(first, second));
        assertSame(tmp, question7Interface.intersection(second, first));

        //Long list (First -> Tmp -> Second), intersects at start of second
        first = ListNode.createFromList(Arrays.asList(1,5,6,9,4,1));
        second = ListNode.createFromList(Arrays.asList(20,15,16,4,3,6,4));
        tmp = ListNode.createFromList(Arrays.asList(15,60,16,20,65));

        tmp2 = first;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = tmp;


        tmp2 = tmp;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        tmp2.next = second;

        assertSame(second, question7Interface.intersection(first, second));
        assertSame(second, question7Interface.intersection(second, first));
    }
}