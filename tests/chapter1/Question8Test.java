package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Question8Test {

    public interface Question8Interface {
        <T extends Number> T[][] zeroMatrix(T[][] matrix);
    }

    @Test
    void zeroMatrix() {
        zeroMatrixTests(Question8::zeroMatrix);
    }

    @Test
    void zeroMatrix2() {
        zeroMatrixTests(Question8::zeroMatrix2);
    }

    void zeroMatrixTests(Question8Interface question8Interface) {
        assertArrayEquals((new Integer[][]{}), question8Interface.zeroMatrix(new Integer[][]{}));
        assertArrayEquals((new Integer[][]{{24, 12}, {-5, 7}}), question8Interface.zeroMatrix(new Integer[][]{{24, 12}, {-5, 7}}));
        assertArrayEquals((new Integer[][]{{0,0},{0,5}}), question8Interface.zeroMatrix(new Integer[][]{{0, 8}, {9, 5}}));
        assertArrayEquals((new Integer[][]{{0,0,0},{0,0,0}}), question8Interface.zeroMatrix(new Integer[][]{{2, 0, 1}, {3, 5, 0}}));
        assertArrayEquals((new Integer[][]{{0,0,0},{0,0,4},{0,0,0},{0,0,4}}),
                question8Interface.zeroMatrix(new Integer[][]{{0,1,3},{10,5,4},{8,0,1},{2,3,4}}));
    }
}