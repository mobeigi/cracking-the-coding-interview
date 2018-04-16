package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question2Test {

    public interface Question2Interface {
        boolean checkPermutation(String s1, String s2);
    }

    @Test
    void checkPermutation() {
        checkPermutationTests(Question2::checkPermutation);
    }

    @Test
    void checkPermutation2() {
        checkPermutationTests(Question2::checkPermutation2);
    }

    void checkPermutationTests(Question2Interface question2Interface) {
        //Valid permutations
        assertTrue(question2Interface.checkPermutation("", ""));
        assertTrue(question2Interface.checkPermutation("abc", "cba"));
        assertTrue(question2Interface.checkPermutation("abcdef", "defcab"));
        assertTrue(question2Interface.checkPermutation("HELLO WORLD", "DLROW OLLEH"));
        assertTrue(question2Interface.checkPermutation("test test", "tstsett e"));
        assertTrue(question2Interface.checkPermutation("apple123", "32palpe1"));
        assertTrue(question2Interface.checkPermutation("a", "a"));
        assertTrue(question2Interface.checkPermutation("z4", "z4"));
        assertTrue(question2Interface.checkPermutation("b ", " b"));

        //Invalid permutations
        assertFalse(question2Interface.checkPermutation("", "MXA"));
        assertFalse(question2Interface.checkPermutation("XVA", ""));
        assertFalse(question2Interface.checkPermutation("abc", "zac"));
        assertFalse(question2Interface.checkPermutation("abcdef", "@bcdef"));
        assertFalse(question2Interface.checkPermutation("HELLO WORLD", "DLROWOLLEH"));
        assertFalse(question2Interface.checkPermutation("test test", "testtest"));
        assertFalse(question2Interface.checkPermutation("apple123", "apple324"));
        assertFalse(question2Interface.checkPermutation("a", "g"));
        assertFalse(question2Interface.checkPermutation("z4", "z2"));
        assertFalse(question2Interface.checkPermutation(" b", "88"));
    }
}