package Chapter2;

import Helpers.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Question6Test {

    private interface Question6Interface {
        <T> boolean isPalindrome(ListNode<T> listNode);
    }

    @Test
    void isPalindrome() {
        isPalindromeTests(Question6::isPalindrome);
    }

    @Test
    void isPalindrome2() {
        isPalindromeTests(Question6::isPalindrome2);
    }

    @Test
    void isPalindrome3() {
        isPalindromeTests(Question6::isPalindrome3);
    }

    void isPalindromeTests(Question6Interface question6Interface) {
        //IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList())));

        //True
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a'))));
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a', 'a'))));
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a', 'c', 'a'))));
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a', 'c', 'c', 'a'))));
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('Z', 'z', 'Z'))));
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('R', 'e', 'e', 'R'))));
        assertTrue(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('H', 'e', 'l', 'l', 'o', ' ', 'o', 'l', 'l', 'e', 'H'))));

        //False
        assertFalse(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a','z'))));
        assertFalse(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a','b','c'))));
        assertFalse(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('a','c','c','b'))));
        assertFalse(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('c','a','c','c'))));
        assertFalse(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('H','e','l','l','o'))));
        assertFalse(question6Interface.isPalindrome(ListNode.createFromList(Arrays.asList('Z','a','z')))); //notice case
    }
}