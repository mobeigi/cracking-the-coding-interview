package Chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question1Test {

    public interface Question1Interface {
        boolean isUnique(String s);
    }
    @Test
    void isUnique() {
        isUniqueTests(Question1::isUnique);
    }

    @Test
    void isUnique2() {
        isUniqueTests(Question1::isUnique2);
    }

    @Test
    void isUnique3() {
        isUniqueTests(Question1::isUnique3);
    }

    void isUniqueTests(Question1Interface question1Interface) {
       assertTrue(question1Interface.isUnique(""));
       assertTrue(question1Interface.isUnique("a"));
       assertTrue(question1Interface.isUnique("9"));
       assertTrue(question1Interface.isUnique("ab"));
       assertTrue(question1Interface.isUnique("abc"));
       assertTrue(question1Interface.isUnique("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
       assertTrue(question1Interface.isUnique("@"));
       assertTrue(question1Interface.isUnique("!@#$%^&*()"));
       assertFalse(question1Interface.isUnique("aa"));
       assertFalse(question1Interface.isUnique("abccba"));
       assertFalse(question1Interface.isUnique("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa"));
       assertFalse(question1Interface.isUnique("abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}