package Chapter1;

import java.util.Arrays;

public class Question7 {

    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     *
     * @param matrix input matrix
     * @return matrix rotated 90 degrees clockwise
     */
    public static int[][] rotateMatrix(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                rotatedMatrix[j][matrix.length-1-i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees.
     *
     * In place approach.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param matrix input matrix
     * @return matrix rotated 90 degrees clockwise
     */
    public static int[][] rotateMatrix2(int[][] matrix) {

        //Matrix length/2 layers exits (outer shells)
        for (int layer = 0; layer < matrix.length/2; ++layer) {
            //Rotate each layer
            int start = layer;
            int end = matrix.length - 1 - layer;

            for (int i = start; i < end; ++i) {
                int offset = i - start;
                int j = end - offset;
                int temp = matrix[start][i];

                //top left = bottom left
                matrix[start][i] = matrix[j][start];

                //bottom left = bottom right
                matrix[j][start] = matrix[end][j];

                //bottom right = top right
                matrix[end][j] = matrix[i][end];

                //top right = top left (stored in temp)
                matrix[i][end] = temp;
            }
        }

        return matrix;
    }
}
