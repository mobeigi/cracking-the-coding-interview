package Chapter1;

public class Question7 {

    /**
     * Rotate Matrix
     *
     * @implSpec Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees.
     *
     * @implNote Naive approach. Create new matrix and set each element individually. High space cost.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     *
     * @param matrix matrix input matrix
     * @param <T> Type for value in matrix
     * @return matrix rotated 90 degrees clockwise
     */
    public static <T> T[][] rotateMatrix(T[][] matrix) {
        T[][] rotatedMatrix = (T[][])new Object[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                rotatedMatrix[j][matrix.length-1-i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    /**
     * Rotate Matrix [EXTERNAL]
     *
     * @implSpec Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees.
     *
     * @implNote In place approach. Iterate for each layer (outer shell) that exists.
     * Rotate each layer, moving each corresponding piece in the 'row' (4 assignments every time)
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param matrix matrix input matrix
     * @param <T> Type for value in matrix
     * @return matrix rotated 90 degrees clockwise
     */
    public static <T> T[][] rotateMatrix2(T[][] matrix) {

        //Matrix length/2 layers exits (outer shells)
        for (int layer = 0; layer < matrix.length/2; ++layer) {
            //Rotate each layer
            int start = layer;
            int end = matrix.length - 1 - layer;

            for (int i = start; i < end; ++i) {
                int offset = i - start;
                int j = end - offset;
                T temp = matrix[start][i];

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
