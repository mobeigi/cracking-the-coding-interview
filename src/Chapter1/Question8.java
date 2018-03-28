package Chapter1;

import java.util.HashSet;

public class Question8 {

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to O.
     *
     * Time Complexity: O(M*N)
     * Space Complexity: O(M*N)
     *
     * @param matrix input MxN matrix
     * @return matrix with zero'd out columns/rows if element 0 was in row/col
     */
    public static int[][] zeroMatrix(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        //For each row, col
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        //Zero out rows cols
        for (Integer row : rows) {
            for (int i = 0; i < matrix[row].length; ++i)
                matrix[row][i] = 0;
        }

        for (Integer col : cols) {
            for (int i = 0; i < matrix.length; ++i)
                matrix[i][col] = 0;
        }

        return matrix;
    }

}
