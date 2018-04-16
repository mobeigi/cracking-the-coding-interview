package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Question3Test {

    public interface Question3Interface {
        char[] urlify(char[] string, int trueLength);
    }

    @Test
    void urlify() {
        urlifyTests(Question3::urlify);
    }

    @Test
    void urlify2() {
        urlifyTests(Question3::urlify2);
    }

    void urlifyTests(Question3Interface question3Interface) {
        assertArrayEquals("".toCharArray(), question3Interface.urlify("".toCharArray() ,0));
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), question3Interface.urlify("Mr John Smith    ".toCharArray(), 13));
        assertArrayEquals("SomeSpacelessString".toCharArray(), question3Interface.urlify("SomeSpacelessString".toCharArray(), 19));
        assertArrayEquals("H%20E%20L%20L%20O%20".toCharArray(), question3Interface.urlify("H E L L O           ".toCharArray(), 10));
        assertArrayEquals("One%20Space".toCharArray(), question3Interface.urlify("One Space  ".toCharArray(), 9));
        assertArrayEquals("%20".toCharArray(), question3Interface.urlify("   ".toCharArray(), 1));
        assertArrayEquals("%20%20%20".toCharArray(), question3Interface.urlify(" %20     ".toCharArray(),5));
        assertArrayEquals("%20%20%20".toCharArray(), question3Interface.urlify("         ".toCharArray(), 3));
    }

}