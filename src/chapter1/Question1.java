package chapter1;

import java.util.HashSet;
import java.util.Set;

public class Question1 {

    /**
     * Is Unique
     *
     * @implSpec Implement an algorithm to determine if a string has all unique characters.
     *
     * @implNote Maintain a set of characters and return false if we see a character that has already been seen.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s String to check
     * @return true if all characters unique or false otherwise
     */
    public static boolean isUnique(String s) {
        Set<Character> charsSeen = new HashSet<>();
        for(Character c : s.toCharArray()) {
            if (charsSeen.contains(c))
                return false;
            else
                charsSeen.add(c);
        }

        return true;
    }

    /**
     * Is Unique
     *
     * @implSpec Implement an algorithm to determine if a string has all unique characters.
     * Do not use additional data structures.
     *
     * @implNote For each character, check remainder of array for occurrence of character and return false if found.
     *
     * Time Complexity: O(N^2) {N-1,N-2,..,1 total iterations => O(N(N-1)/2) = O(N^2)}
     * Space Complexity: O(1)
     *
     * @param s String to check
     * @return true if all characters unique or false otherwise
     */
    public static boolean isUnique2(String s) {
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i+1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j))
                    return false;
            }
        }

        return true;
    }

    /**
     * Is Unique [EXTERNAL]
     *
     * @implSpec Implement an algorithm to determine if a string has all unique characters.
     * Do not use additional data structures.
     *
     * @implNote Assuming each character is from 7-bit ASCII set (128 chars), use a boolean array to keep track of seen
     * characters and return false if seen character found.
     *
     * Time Complexity: O(N) {arguably O(1) as we never iterate more than 128 times}
     * Space Complexity: O(1)
     *
     * @param s String to check
     * @return true if all characters unique or false otherwise
     */
    public static boolean isUnique3(String s) {
        //If length is longer than this, then a repeat character MUST have been used
        if (s.length() > 128)
            return false;

        boolean[] seen = new boolean[128];

        for (Character c : s.toCharArray()) {
            if (seen[c])
                return false;

            seen[c] = true;
        }

        return true;
    }
}
