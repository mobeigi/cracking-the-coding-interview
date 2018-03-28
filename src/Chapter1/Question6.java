package Chapter1;

import java.awt.*;

public class Question6 {

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
     * become smaller than the original string, your method should return the original string.
     * You can assume the string has only uppercase and lowercase letters (a - z).
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s input string
     * @return compressed string if shorter and original input string s otherwise
     */
    public static String compressString(String s) {
        if (s.isEmpty())
            return s;

        StringBuilder res = new StringBuilder();
        Character c = s.charAt(0);
        int i = 0, lastIndex = 0; //current and last index

        //Iterate until new character or end of string reached
        for (; i < s.length(); ++i) {
            //Add last segment to result string
            if (c != s.charAt(i)) {
                res.append(c);
                res.append(i-lastIndex);
                c = s.charAt(i);
                lastIndex = i;
            }
        }

        //Process final loop
        res.append(c);
        res.append(i-lastIndex);

        //Return shortest string
        return (s.length() < res.length()) ? s : res.toString();
    }
}
