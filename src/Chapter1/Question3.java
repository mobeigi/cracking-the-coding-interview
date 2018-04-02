package Chapter1;

public class Question3 {
    private static final char[] REPLACEMENT = {'%', '2', '0'};

    /**
     * URLify
     *
     * @implSpec Write a method to replace all spaces in a string with '%20:
     * You may assume that the string has sufficient space at the end to hold the additional characters,
     * and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character
     * array so that you can perform this operation in place.)
     *
     * @implNote Iterate array and if space encountered, shift rest of array down 2 positions making room for
     * replacement to occur.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param string input string to perform replacements on
     * @return string with all spaces replaced by %20
     */
    public static char[] urlify(char[] string, int trueLength) {
        for (int i = 0; i < string.length; ++i) {
            if (string[i] == ' ') {
                //Shift down rest of array REPLACEMENT.length positions
                for (int j = string.length - 1; j > i+(REPLACEMENT.length-1); --j) {
                    string[j] = string[j-(REPLACEMENT.length-1)];
                }

                //Perform replacement
                for (int k = 0; k < REPLACEMENT.length; ++k)
                    string[i+k] = REPLACEMENT[k];

                //Go to end of replacement position
                i+= REPLACEMENT.length-1;
            }
        }

        return string;
    }

    /**
     * URLify
     *
     * @implSpec Write a method to replace all spaces in a string with '%20:
     * You may assume that the string has sufficient space at the end to hold the additional characters,
     * and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character
     * array so that you can perform this operation in place.)
     *
     * @implNote Using a left index at trueLength and right index at end of string, iterate over string in reverse.
     * Each iteration copy one non-space char from left index to right index or copy the replacement string.
     * Once right index reaches left index, the remainder of the string will remain the same and we can exit the loop.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param string input string to perform replacements on
     * @return string with all spaces replaced by %20
     */
    public static char[] urlify2(char[] string, int trueLength) {
        for (int r = string.length - 1, l = trueLength - 1; l < r; --r, --l) {
            if (string[l] == ' ') {
                //Perform replacement
                for (int k = 0; k < REPLACEMENT.length; ++k)
                    string[r-k] = REPLACEMENT[REPLACEMENT.length-1-k];

                r-= (REPLACEMENT.length - 1);
            }
            else
                string[r] = string[l];
        }

        return string;
    }
}
