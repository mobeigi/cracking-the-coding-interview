package Chapter1;

import Chapter1.Question2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question2Test {

    @Test
    void checkPermutation() {
        //Valid permutations
        assertTrue(Question2.checkPermutation("", ""));
        assertTrue(Question2.checkPermutation("abc", "cba"));
        assertTrue(Question2.checkPermutation("abcdef", "defcab"));
        assertTrue(Question2.checkPermutation("HELLO WORLD", "DLROW OLLEH"));
        assertTrue(Question2.checkPermutation("test test", "tstsett e"));
        assertTrue(Question2.checkPermutation("apple123", "32palpe1"));
        assertTrue(Question2.checkPermutation("a", "a"));
        assertTrue(Question2.checkPermutation("z4", "z4"));
        assertTrue(Question2.checkPermutation("b ", " b"));

        //Invalid permutations
        assertFalse(Question2.checkPermutation("", "MXA"));
        assertFalse(Question2.checkPermutation("XVA", ""));
        assertFalse(Question2.checkPermutation("abc", "zac"));
        assertFalse(Question2.checkPermutation("abcdef", "@bcdef"));
        assertFalse(Question2.checkPermutation("HELLO WORLD", "DLROWOLLEH"));
        assertFalse(Question2.checkPermutation("test test", "testtest"));
        assertFalse(Question2.checkPermutation("apple123", "apple324"));
        assertFalse(Question2.checkPermutation("a", "g"));
        assertFalse(Question2.checkPermutation("z4", "z2"));
        assertFalse(Question2.checkPermutation(" b", "88"));
    }

    @Test
    void checkPermutation2() {
        //Valid permutations
        assertTrue(Question2.checkPermutation2("", ""));
        assertTrue(Question2.checkPermutation2("abc", "cba"));
        assertTrue(Question2.checkPermutation2("abcdef", "defcab"));
        assertTrue(Question2.checkPermutation2("HELLO WORLD", "DLROW OLLEH"));
        assertTrue(Question2.checkPermutation2("test test", "tstsett e"));
        assertTrue(Question2.checkPermutation2("apple123", "32palpe1"));
        assertTrue(Question2.checkPermutation2("a", "a"));
        assertTrue(Question2.checkPermutation2("z4", "z4"));
        assertTrue(Question2.checkPermutation2("b ", " b"));

        //Invalid permutations
        assertFalse(Question2.checkPermutation2("", "MXA"));
        assertFalse(Question2.checkPermutation2("XVA", ""));
        assertFalse(Question2.checkPermutation2("abc", "zac"));
        assertFalse(Question2.checkPermutation2("abcdef", "@bcdef"));
        assertFalse(Question2.checkPermutation2("HELLO WORLD", "DLROWOLLEH"));
        assertFalse(Question2.checkPermutation2("test test", "testtest"));
        assertFalse(Question2.checkPermutation2("apple123", "apple324"));
        assertFalse(Question2.checkPermutation2("a", "g"));
        assertFalse(Question2.checkPermutation2("z4", "z2"));
        assertFalse(Question2.checkPermutation2(" b", "88"));
    }
}