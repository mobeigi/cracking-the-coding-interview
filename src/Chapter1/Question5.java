package Chapter1;

import java.util.HashMap;

public class Question5 {

    /**
     * One Away: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, checks if they are
     * one edit (or zero edits) away.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
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
}
