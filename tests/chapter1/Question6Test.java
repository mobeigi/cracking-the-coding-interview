package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Question6Test {

    @Test
    void compressString() {
        //Compressed String returns
        assertEquals("a2b1c5a3", Question6.compressString("aabcccccaaa"));
        assertEquals("A4a4A4a4", Question6.compressString("AAAAaaaaAAAAaaaa"));
        assertEquals("z3o14m4", Question6.compressString("zzzoooooooooooooommmm"));
        assertEquals("r1e168", Question6.compressString("reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                                                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                                                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));

        //Original string returns
        assertEquals("", Question6.compressString(""));
        assertEquals("a", Question6.compressString("a"));
        assertEquals("ZEB", Question6.compressString("ZEB"));
        assertEquals("ab", Question6.compressString("ab"));
        assertEquals("HELLO", Question6.compressString("HELLO"));
    }
}