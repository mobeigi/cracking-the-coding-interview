package Chapter1;

public class Question6 {

    /**
     * String Compression
     *
     * @implSpec Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
     * become smaller than the original string, your method should return the original string.
     * You can assume the string has only uppercase and lowercase letters (a - z).
     *
     * @implNote Iterate from start of string until a new character is encountered, then simply add the previous
     * character and count to a string builder. Then return either original string or compressed string
     * (whichever is shortest).
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

        StringBuilder compressedString = new StringBuilder();
        int count = 0; //current and last index

        //Iterate until new character or end of string reached
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            ++count;

            //Add last segment to result string
            if (i+1 >= s.length() || c != s.charAt(i+1)) {
                compressedString.append(c);
                compressedString.append(count);
                count = 0;
            }
        }

        //Return shortest string
        return (s.length() < compressedString.length()) ? s : compressedString.toString();
    }
}
