package Chapter1;

import java.util.HashSet;
import java.util.Set;

public class Question1 {

    /**
     * Check if all characters in a string are unique
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
            if (charsSeen.contains(c)) {
                return false;
            }
            else {
                charsSeen.add(c);
            }
        }

        return true;
    }

    /**
     * Check if all characters in a string are unique.
     * Restriction: Do not use any additional data structures
     *
     * Time Complexity: O(N^2)
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
}
