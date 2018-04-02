package Chapter1;

import java.util.HashMap;

public class Question4 {

    /**
     * Palindrome Permutation
     *
     * @implSpec Given a string, checks if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     * Spaces do not break the palindrome.
     *
     * @implNote Store frequency of each character in hashmap. Then, check to ensure there is at most 1 character with
     * an odd frequency. If this condition is not satisfied, the input was not a palindrome permutation.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s input string
     * @return true if palindrome permutation, false otherwise
     */
    public static boolean isPalindromePermutation(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        //Store frequency of each char in map
        //Spaces don't count (per spec)
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != ' ')
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        //For even length strings, all frequency counts must be even
        //For odd length strings, only 1 odd length count is permitted
        boolean oneOddSeen = false;
        for (Integer count : frequencyMap.values()) {
            if (count % 2 != 0) {
                if (oneOddSeen)
                    return false;
                oneOddSeen = true;
            }
        }

        return true;
    }
}
