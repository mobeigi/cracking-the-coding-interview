package chapter1;

import java.util.HashSet;

public class Question8 {

    /**
     * Zero Matrix
     *
     * @implSpec Write an algorithm such that if an element in an MxN matrix is 0,its entire row and column
     * are set to 0.
     *
     * @implNote Create two hashsets to record all rows and columns which had a zero in them.
     * Next, iterate both hashsets and zero out each row/column respectively.
     *
     * Time Complexity: O(M*N) { M*N to fill hashsets, then M*N + N*M to iterate hashsets. O(3(M*N)) => O(M*N)}
     * Space Complexity: O(M+N)
     *
     * @param matrix input MxN matrix
     * @param <T> Type for value in matrix
     * @return matrix with zero'd out columns/rows if element 0 was in row/col
     */
    public static <T extends Number> T[][] zeroMatrix(T[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        //For each row, col
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j].intValue() == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        //Zero out rows cols
        for (Integer row : rows) {
            nullifyRow(matrix, row);
        }

        for (Integer col : cols) {
            nullifyColumn(matrix, col);
        }

        return matrix;
    }

    /**
     * Zero Matrix [EXTERNAL]
     *
     * @implSpec Write an algorithm such that if an element in an MxN matrix is 0,its entire row and column
     * are set to 0.
     *
     * @implNote Solution from end of book. Use two booleans to store whether row 0 and col 0 should be nullified.
     * Then use, row 0 and col 0 as extra space. For rest of array:
     * If 0 encountered, set the element in row 0/col 0 matching that row or col to 0.
     * Then, nullify each row/col based on row 0 and col 0.
     * Finally, nullify row 0 and col 0 based on stored booleans.
     *
     * Time Complexity: O(M*N)
     * Space Complexity: O(1)
     *
     * @param matrix input MxN matrix
     * @param <T> Type for value in matrix
     * @return matrix with zero'd out columns/rows if element 0 was in row/col
     */
    public static <T extends Number> T[][] zeroMatrix2(T[][] matrix) {
        if (matrix.length == 0)
            return matrix;

        //Check if first row and first column have any zeros
        boolean firstRowHasZero = false, firstColHasZero = false;

        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i].intValue() == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0].intValue() == 0) {
                firstColHasZero = true;
                break;
            }
        }

        //Check for zeros in rest of array
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j].intValue() == 0) {
                    matrix[i][0] = (T)Integer.valueOf(0);
                    matrix[0][j] = (T)Integer.valueOf(0);
                }
            }
        }

        //Nullify rows based on values in first column
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0].intValue() == 0) {
                nullifyRow(matrix, i);
            }
        }

        //Nullify columns based on values in first row
        for (int i = 1; i < matrix[0].length; ++i) {
            if (matrix[0][i].intValue() == 0) {
                nullifyColumn(matrix, i);
            }
        }

        //Nullify first row/column if necessary
        if (firstRowHasZero)
            nullifyRow(matrix, 0);

        if (firstColHasZero)
            nullifyColumn(matrix, 0);

        return matrix;
    }

    /**
     * Helper: nullify rows to zero
     *
     * @param matrix input MxN matrix
     * @param row row index to nullify
     * @param <T> Type for value in matrix
     */
    private static <T extends Number> void nullifyRow(T[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; ++i)
            matrix[row][i] = (T)Integer.valueOf(0);
    }

    /**
     * Helper: nullify columns to zero
     *
     * @param matrix input MxN matrix
     * @param col column index to nullify
     * @param <T> Type for value in matrix
     */
    private static <T extends Number> void nullifyColumn(T[][] matrix, int col) {
        for (int i = 0; i < matrix.length; ++i)
            matrix[i][col] = (T)Integer.valueOf(0);
    }

}
