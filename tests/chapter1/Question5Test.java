package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question5Test {

    public interface Question5Interface {
        boolean oneAway(String s1, String s2);
    }

    @Test
    void oneAway() {
        oneAwayTests(Question5::oneAway);
    }

    @Test
    void oneAway2() {
        oneAwayTests(Question5::oneAway2);
    }

    void oneAwayTests(Question5Interface question5Interface) {
        //True
        assertTrue(question5Interface.oneAway("pale", "ple"));
        assertTrue(question5Interface.oneAway("pales", "pale"));
        assertTrue(question5Interface.oneAway("pale", "bale"));
        assertTrue(question5Interface.oneAway("", "a"));
        assertTrue(question5Interface.oneAway("hey", "hiy"));
        assertTrue(question5Interface.oneAway("apple123456", "apple1234567"));
        assertTrue(question5Interface.oneAway("apple123456", "2apple123456"));
        assertTrue(question5Interface.oneAway("apple123456", "apple12345"));
        assertTrue(question5Interface.oneAway("apple123456", "pple123456"));

        //False
        assertFalse(question5Interface.oneAway("pale", "bake"));
        assertFalse(question5Interface.oneAway("", "ab"));
        assertFalse(question5Interface.oneAway("hey", "hai"));
        assertFalse(question5Interface.oneAway("apple123456", "apple12345678"));
        assertFalse(question5Interface.oneAway("apple123456", "78apple123456"));
        assertFalse(question5Interface.oneAway("apple123456", "apple1234"));
        assertFalse(question5Interface.oneAway("apple123456", "ple123456"));
    }

}