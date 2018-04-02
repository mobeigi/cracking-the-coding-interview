package Chapter1;

import Chapter1.Question1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question1Test {

    @Test
    void isUnique() {
       assertTrue(Question1.isUnique(""));
       assertTrue(Question1.isUnique("a"));
       assertTrue(Question1.isUnique("9"));
       assertTrue(Question1.isUnique("ab"));
       assertTrue(Question1.isUnique("abc"));
       assertTrue(Question1.isUnique("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
       assertTrue(Question1.isUnique("@"));
       assertTrue(Question1.isUnique("!@#$%^&*()"));
       assertFalse(Question1.isUnique("aa"));
       assertFalse(Question1.isUnique("abccba"));
       assertFalse(Question1.isUnique("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa"));
       assertFalse(Question1.isUnique("abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    void isUnique2() {
        assertTrue(Question1.isUnique2(""));
        assertTrue(Question1.isUnique2("a"));
        assertTrue(Question1.isUnique2("9"));
        assertTrue(Question1.isUnique2("ab"));
        assertTrue(Question1.isUnique2("abc"));
        assertTrue(Question1.isUnique2("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertTrue(Question1.isUnique2("@"));
        assertTrue(Question1.isUnique2("!@#$%^&*()"));
        assertFalse(Question1.isUnique2("aa"));
        assertFalse(Question1.isUnique2("abccba"));
        assertFalse(Question1.isUnique2("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa"));
        assertFalse(Question1.isUnique2("abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    void isUnique3() {
        assertTrue(Question1.isUnique3(""));
        assertTrue(Question1.isUnique3("a"));
        assertTrue(Question1.isUnique3("9"));
        assertTrue(Question1.isUnique3("ab"));
        assertTrue(Question1.isUnique3("abc"));
        assertTrue(Question1.isUnique3("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertTrue(Question1.isUnique3("@"));
        assertTrue(Question1.isUnique3("!@#$%^&*()"));
        assertFalse(Question1.isUnique3("aa"));
        assertFalse(Question1.isUnique3("abccba"));
        assertFalse(Question1.isUnique3("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa"));
        assertFalse(Question1.isUnique3("abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}