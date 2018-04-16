package chapter1;

import java.util.HashMap;

public class Question5 {

    /**
     * One Away
     *
     * @implSpec There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, checks if they are one edit (or zero edits) away.
     *
     * @implNote First, check special cases of more than 1 insertion and more than 1 removal which cannot be one away.
     * Next, get frequency map of each string. Count differences in frequency in each string.
     * Strings are one away only if there is 1 or 0 edits (differences).
     *
     * Time Complexity: O(A+B) {A is length of s1, B is length of s2}
     * Space Complexity: O(A+B)
     *
     * @param s1 starting string
     * @param s2 ending string (after 0 or more edits)
     * @return true if one (or zero) edits away, false otherwise
     */
    public static boolean oneAway(String s1, String s2) {
        //Check for more than 1 insertion or removal
        if (s2.length() > s1.length() + 1) //more than 1 insertion
            return false;
        else if (s2.length() < s1.length() - 1) //more than 1 removal
            return false;

        //Get frequency map for each string
        int diffCount = 0;
        HashMap<Character, Integer> s1Chars = new HashMap<>();
        HashMap<Character, Integer> s2Chars = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i)
            s1Chars.put(s1.charAt(i), s1Chars.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i < s2.length(); ++i)
            s2Chars.put(s2.charAt(i), s2Chars.getOrDefault(s2.charAt(i), 0) + 1);

        //Count differences in frequencies in each string
        for (Character c : s1Chars.keySet()) {
            if (!s1Chars.get(c).equals(s2Chars.get(c)))
                ++diffCount;
        }

        //Return true if only 1 or 0 edits (differences)
        return (diffCount <= 1);
    }

    /**
     * One Away [EXTERNAL]
     *
     * @implSpec There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, checks if they are one edit (or zero edits) away.
     *
     * @implNote Iterate and compare strings character by character maintaining two indices.
     * If a difference is found, increment diff count and increment the larger string index (or both if both strings
     * are the same length). Strings are one away only if there is 1 or 0 edits (differences).
     *
     * Time Complexity: O(min(A,B)) {A is length of s1, B is length of s2}
     * Space Complexity: O(1)
     *
     * @param s1 starting string
     * @param s2 ending string (after 0 or more edits)
     * @return true if one (or zero) edits away, false otherwise
     */
    public static boolean oneAway2(String s1, String s2) {
        //Check for more than 1 insertion or removal
        if (s2.length() > s1.length() + 1) //more than 1 insertion
            return false;
        else if (s2.length() < s1.length() - 1) //more than 1 removal
            return false;

        int diffCount = 0;

        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                ++diffCount;

                //Increment i if s1>=s2, and
                //Increment j if s2>=s1
                //This allows proper incrementing for replacement, insertion and deletion
                if (s1.length() >= s2.length())
                    ++i;
                if (s2.length() >= s1.length())
                    ++j;
            }
            else { //chars equal, increment both indices to next position
                ++i;
                ++j;
            }
        }

        //Return true if only 1 or 0 edits (differences)
        return (diffCount <= 1);
    }
}
