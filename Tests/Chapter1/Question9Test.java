package Chapter1;

import Chapter1.Question9;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Question9Test {

    @Test
    void isRotation() {
        //True
        assertTrue(Question9.isRotation("", ""));
        assertTrue(Question9.isRotation("test", "stte"));
        assertTrue(Question9.isRotation("same", "same"));
        assertTrue(Question9.isRotation("ffffff", "ffffff"));
        assertTrue(Question9.isRotation("waterbottle", "erbottlewat"));
        assertTrue(Question9.isRotation("abcdef123456", "123456abcdef"));
        assertTrue(Question9.isRotation("abcdef123456", "23456abcdef1"));
        assertTrue(Question9.isRotation("abcdef123456", "3456abcdef12"));
        assertTrue(Question9.isRotation("abcdef123456", "456abcdef123"));
        assertTrue(Question9.isRotation("abcdef123456", "56abcdef1234"));
        assertTrue(Question9.isRotation("abcdef123456", "6abcdef12345"));

        //False
        assertFalse(Question9.isRotation("waterbottle", "welattterbo"));
        assertFalse(Question9.isRotation("", "a"));
        assertFalse(Question9.isRotation("test", "ttse"));
        assertFalse(Question9.isRotation("same", "different"));
        assertFalse(Question9.isRotation("ffffff", "ffffffffff"));
    }

    @Test
    void isSubString() {
        //True
        assertTrue(Question9.isSubString("", ""));
        assertTrue(Question9.isSubString("", "abc"));
        assertTrue(Question9.isSubString("a", "ab"));
        assertTrue(Question9.isSubString("en", "eileen"));
        assertTrue(Question9.isSubString("ant", "antler"));
        assertTrue(Question9.isSubString("room", "rooroom"));
        assertTrue(Question9.isSubString("a", "a"));
        assertTrue(Question9.isSubString("ze90238hfj", "ze90238hfj4dw6d2"));
        assertTrue(Question9.isSubString("00.55", "00.55.88.44"));
        assertTrue(Question9.isSubString("    ", "    "));
        assertTrue(Question9.isSubString("and", "sand"));
        assertTrue(Question9.isSubString("test", "tesnottest"));

        //False
        assertFalse(Question9.isSubString("a", "bz"));
        assertFalse(Question9.isSubString("a", "b2"));
        assertFalse(Question9.isSubString("en", "eilein"));
        assertFalse(Question9.isSubString("ant", "anrler"));
        assertFalse(Question9.isSubString("room", "romroo"));
        assertFalse(Question9.isSubString("Z", "a"));
        assertFalse(Question9.isSubString("ze90238hfj", "z1e90238hfj1"));
        assertFalse(Question9.isSubString("00.55", "00.33.88.B4"));
        assertFalse(Question9.isSubString("    ", "  a  "));
        assertFalse(Question9.isSubString("and", "lan9"));
        assertFalse(Question9.isSubString("test", "tesnottes"));

    }
}