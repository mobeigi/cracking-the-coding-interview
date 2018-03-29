package Tests.Chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Chapter1.Question3;

class Question3Test {

    @Test
    void urlify() {
        assertArrayEquals("".toCharArray(), Question3.urlify("".toCharArray()));
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), Question3.urlify("Mr John Smith    ".toCharArray()));
        assertArrayEquals("SomeSpacelessString".toCharArray(), Question3.urlify("SomeSpacelessString".toCharArray()));
        assertArrayEquals("H%20E%20L%20L%20O%20".toCharArray(), Question3.urlify("H E L L O           ".toCharArray()));
        assertArrayEquals("One%20Space".toCharArray(), Question3.urlify("One Space  ".toCharArray()));
        assertArrayEquals("%20".toCharArray(), Question3.urlify("   ".toCharArray()));
        assertArrayEquals("%20%20%20".toCharArray(), Question3.urlify(" %20     ".toCharArray()));
        assertArrayEquals("%20%20%20".toCharArray(), Question3.urlify("         ".toCharArray()));
    }
}