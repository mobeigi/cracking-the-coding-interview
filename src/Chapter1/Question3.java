package Chapter1;

public class Question3 {
    private static final char[] REPLACEMENT = {'%', '2', '0'};

    /**
     * Replace spaces in string with %20
     * Can assume char array is large enough to store replacement
     *
     * Time Complexity: O(N^3)
     * Space Complexity: O(1)
     *
     * @param string input string to perform replacements on
     * @return string with spaces replaced by %20
     */
    public static char[] urlify(char[] string) {
        for (int i = 0; i < string.length; ++i) {
            if (string[i] == ' ') {
                //Shift down rest of array 2 positions
                for (int j = string.length - 1; j > i+2; --j) {
                    string[j] = string[j-2];
                }

                //Perform replacement
                string[i] = REPLACEMENT[0];
                string[i+1] = REPLACEMENT[1];
                string[i+2] = REPLACEMENT[2];
            }
        }

        return string;
    }
}
