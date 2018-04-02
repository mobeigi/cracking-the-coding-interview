package Chapter1;

import Chapter1.Question3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Question3Test {

    @Test
    void urlify() {
        assertArrayEquals("".toCharArray(), Question3.urlify("".toCharArray() ,0));
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), Question3.urlify("Mr John Smith    ".toCharArray(), 13));
        assertArrayEquals("SomeSpacelessString".toCharArray(), Question3.urlify("SomeSpacelessString".toCharArray(), 19));
        assertArrayEquals("H%20E%20L%20L%20O%20".toCharArray(), Question3.urlify("H E L L O           ".toCharArray(), 10));
        assertArrayEquals("One%20Space".toCharArray(), Question3.urlify("One Space  ".toCharArray(), 9));
        assertArrayEquals("%20".toCharArray(), Question3.urlify("   ".toCharArray(), 1));
        assertArrayEquals("%20%20%20".toCharArray(), Question3.urlify(" %20     ".toCharArray(),5));
        assertArrayEquals("%20%20%20".toCharArray(), Question3.urlify("         ".toCharArray(), 3));
    }

    @Test
    void urlify2() {
        assertArrayEquals("".toCharArray(), Question3.urlify2("".toCharArray() ,0));
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), Question3.urlify2("Mr John Smith    ".toCharArray(), 13));
        assertArrayEquals("SomeSpacelessString".toCharArray(), Question3.urlify2("SomeSpacelessString".toCharArray(), 19));
        assertArrayEquals("H%20E%20L%20L%20O%20".toCharArray(), Question3.urlify2("H E L L O           ".toCharArray(), 10));
        assertArrayEquals("One%20Space".toCharArray(), Question3.urlify2("One Space  ".toCharArray(), 9));
        assertArrayEquals("%20".toCharArray(), Question3.urlify2("   ".toCharArray(), 1));
        assertArrayEquals("%20%20%20".toCharArray(), Question3.urlify2(" %20     ".toCharArray(),5));
        assertArrayEquals("%20%20%20".toCharArray(), Question3.urlify2("         ".toCharArray(), 3));
    }
}