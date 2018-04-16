package chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Question8Test {

    public interface Question8Interface {
        <T> ListNode<T> loopDetection(ListNode<T> listNode);
    }

    @Test
    void loopDetection() {
        loopDetectionTests(Question8::loopDetection);
    }

    @Test
    void loopDetection2() {
        loopDetectionTests(Question8::loopDetection2);
    }

    void loopDetectionTests(Question8Interface question8Interface) {
        //Variables
        ListNode<Integer> listNode, circularNode, tmp;
        int count = 0, circularNodePosition = 0;

        //Null list
        assertThrows(IllegalArgumentException.class, () -> question8Interface.loopDetection(ListNode.createFromList(Arrays.asList())));;

        //Random values
        listNode = tmp = new ListNode<>(50);
        circularNode = null;
        count = 6;
        circularNodePosition = 2;
        while (count != 0) {
            tmp.next = new ListNode<>((int)(Math.random()*100));

            if (count == circularNodePosition)
                circularNode = tmp.next;

            tmp = tmp.next;
            --count;
        }
        assertNull(question8Interface.loopDetection(listNode)); //ensure no circular list
        tmp.next = circularNode; //create circular list
        assertEquals(circularNode, question8Interface.loopDetection(listNode)); //ensure correct node returned

        //Circular node is first node
        listNode = tmp = new ListNode<>(50);
        circularNode = listNode;
        count = 50;
        while (count != 0) {
            tmp.next = new ListNode<>((int)(Math.random()*100));

            tmp = tmp.next;
            --count;
        }
        assertNull(question8Interface.loopDetection(listNode)); //ensure no circular list
        tmp.next = circularNode; //create circular list
        assertEquals(circularNode, question8Interface.loopDetection(listNode)); //ensure correct node returned

        //Circular node is last node
        listNode = tmp = new ListNode<>(50);
        circularNode = null;
        count = 10;
        circularNodePosition = 10;
        while (count != 0) {
            tmp.next = new ListNode<>((int)(Math.random()*100));

            if (count == circularNodePosition)
                circularNode = tmp.next;

            tmp = tmp.next;
            --count;
        }
        assertNull(question8Interface.loopDetection(listNode)); //ensure no circular list
        tmp.next = circularNode; //create circular list
        assertEquals(circularNode, Question8.loopDetection(listNode)); //ensure correct node returned

    }
}