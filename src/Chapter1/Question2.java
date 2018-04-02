package Chapter1;

import java.util.Arrays;
import java.util.HashMap;

public class Question2 {

    /**
     * Check Permutation
     *
     * @implSpec Given two strings, write a method to decide if one is a permutation of the other.
     *
     * @implNote Sort both strings as arrays in N LOG N time and then compare them in N time.
     *
     * Time Complexity: O(N LOG N)
     * Space Complexity: O(N) {N+N to store both strings as arrays}
     *
     * @param s1 string 1
     * @param s2 string 2
     * @return true if one string is permutation of other, false otherwise
     */
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        //Sort both strings
        char[] s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);

        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s2CharArray);

        //Ensure one string is substring of other
        return Arrays.equals(s1CharArray, s2CharArray);
    }

    /**
     * Check Permutation
     *
     * @implSpec Given two strings, write a method to decide if one is a permutation of the other.
     *
     * @implNote Store a count for each character, adding +1 if found in s1 and -1 if found in s2.
     * Tally should be 0 for all characters if strings are valid permutations.
     *
     * Time Complexity: O(N) { N first iteration to tally and N second iteration to check hashmap}
     * Space Complexity: O(N)
     *
     * @param s1 string 1
     * @param s2 string 2
     * @return true if one string is permutation of other, false otherwise
     */
    public static boolean checkPermutation2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        //Tally method
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i) {
            //Add 1 for s1
            char c1 = s1.charAt(i);
            count.put(c1, count.getOrDefault(c1, 0) + 1);

            //Remove 1 for s2
            char c2 = s2.charAt(i);
            count.put(c2, count.getOrDefault(c2, 0) - 1);
        }

        for (Integer i : count.values()) {
            if (i != 0)
                return false;
        }

        return true;
    }
}
