package Chapter1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question4 {

    /**
     * Given a string, checks if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     * Spaces do not break the palindrome.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s input string
     * @return true if palindrome permutation, false otherwise
     */
    public static boolean isPalindromePermutation(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int length = s.length();

        //Store frequency of each char in map
        //Spaces don't count (per spec)
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != ' ')
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
            else
                --length;
        }

        //For even length strings, all frequency counts must be even
        //For odd length strings, only 1 odd length count is permitted
        boolean oneOddSeen = false;
        for (Integer count : frequencyMap.values()) {
            if (count % 2 != 0) {
                if ((length % 2 != 0) && !oneOddSeen)
                    oneOddSeen = true;
                else
                    return false;
            }
        }

        return true;
    }
}
