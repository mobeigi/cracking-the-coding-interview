package Chapter1;

import Chapter1.Question5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question5Test {

    @Test
    void oneAway() {
        //True
        assertTrue(Question5.oneAway("pale", "ple"));
        assertTrue(Question5.oneAway("pales", "pale"));
        assertTrue(Question5.oneAway("pale", "bale"));
        assertTrue(Question5.oneAway("", "a"));
        assertTrue(Question5.oneAway("hey", "hiy"));
        assertTrue(Question5.oneAway("apple123456", "apple1234567"));
        assertTrue(Question5.oneAway("apple123456", "2apple123456"));
        assertTrue(Question5.oneAway("apple123456", "apple12345"));
        assertTrue(Question5.oneAway("apple123456", "pple123456"));

        //False
        assertFalse(Question5.oneAway("pale", "bake"));
        assertFalse(Question5.oneAway("", "ab"));
        assertFalse(Question5.oneAway("hey", "hai"));
        assertFalse(Question5.oneAway("apple123456", "apple12345678"));
        assertFalse(Question5.oneAway("apple123456", "78apple123456"));
        assertFalse(Question5.oneAway("apple123456", "apple1234"));
        assertFalse(Question5.oneAway("apple123456", "ple123456"));
    }

    @Test
    void oneAway2() {
        //True
        assertTrue(Question5.oneAway2("pale", "ple"));
        assertTrue(Question5.oneAway2("pales", "pale"));
        assertTrue(Question5.oneAway2("pale", "bale"));
        assertTrue(Question5.oneAway2("", "a"));
        assertTrue(Question5.oneAway2("hey", "hiy"));
        assertTrue(Question5.oneAway2("apple123456", "apple1234567"));
        assertTrue(Question5.oneAway2("apple123456", "2apple123456"));
        assertTrue(Question5.oneAway2("apple123456", "apple12345"));
        assertTrue(Question5.oneAway2("apple123456", "pple123456"));

        //False
        assertFalse(Question5.oneAway2("pale", "bake"));
        assertFalse(Question5.oneAway2("", "ab"));
        assertFalse(Question5.oneAway2("hey", "hai"));
        assertFalse(Question5.oneAway2("apple123456", "apple12345678"));
        assertFalse(Question5.oneAway2("apple123456", "78apple123456"));
        assertFalse(Question5.oneAway2("apple123456", "apple1234"));
        assertFalse(Question5.oneAway2("apple123456", "ple123456"));
    }
}