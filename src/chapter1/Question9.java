package chapter1;

public class Question9 {

    /**
     * String Rotation
     *
     * @implSpec Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call
     * to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
     *
     * @implNote Concatenate the original string twice to produce a string which contains all possible rotations.
     * Then if our input string is a substring of this resultant string, it is a valid rotation.
     *
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N) {string of 2N size is created and passed to isSubString}
     *
     * @param s1 original string
     * @param s2 rotated string to check
     * @return true if s2 is rotation of s1, false otherwise
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        //concatenating original string twice produces string which contains all possible rotations
        return isSubString(s2, s1+s1); //alternatively: (s1+s1).contains(s2)
    }

    /**
     * Helper: Is Substring
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s1 needle string
     * @param s2 haystack string
     * @return true if s1 substring of s2, false otherwise
     */
    public static boolean isSubString(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int count = 0;

        //Loop until count matches needle length (indicating match) or until we exhaust haystack
        for (int j = 0; j < s2.length() && count < s1.length(); ++j) {
            if (s1.charAt(count) == s2.charAt(j)) {
                ++count;
            }
            else {
                //Redo iteration to handle adjacent duplicate char case
                if (count > 0)
                    --j;

                //Reset counter
                count = 0;
            }
        }

        return (count == s1.length());
    }
}
