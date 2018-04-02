package Chapter1;

import Chapter1.Question4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question4Test {

    @Test
    void isPalindromePermutation() {
        //True
        assertTrue(Question4.isPalindromePermutation(""));
        assertTrue(Question4.isPalindromePermutation("a"));
        assertTrue(Question4.isPalindromePermutation("taco cat"));
        assertTrue(Question4.isPalindromePermutation("atco cta"));
        assertTrue(Question4.isPalindromePermutation("HellolleH"));
        assertTrue(Question4.isPalindromePermutation("HeHellollo"));
        assertTrue(Question4.isPalindromePermutation("HoHell olle"));

        //False
        assertFalse(Question4.isPalindromePermutation("ta"));
        assertFalse(Question4.isPalindromePermutation("$sfv"));
        assertFalse(Question4.isPalindromePermutation("ban"));
        assertFalse(Question4.isPalindromePermutation("sand"));
    }
}