package Chapter1;

import Chapter1.Question8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Question8Test {

    @Test
    void zeroMatrix() {
        assertArrayEquals((new Integer[][]{}), Question8.zeroMatrix(new Integer[][]{}));
        assertArrayEquals((new Integer[][]{{24, 12}, {-5, 7}}), Question8.zeroMatrix(new Integer[][]{{24, 12}, {-5, 7}}));
        assertArrayEquals((new Integer[][]{{0,0},{0,5}}), Question8.zeroMatrix(new Integer[][]{{0, 8}, {9, 5}}));
        assertArrayEquals((new Integer[][]{{0,0,0},{0,0,0}}), Question8.zeroMatrix(new Integer[][]{{2, 0, 1}, {3, 5, 0}}));
        assertArrayEquals((new Integer[][]{{0,0,0},{0,0,4},{0,0,0},{0,0,4}}),
                Question8.zeroMatrix(new Integer[][]{{0,1,3},{10,5,4},{8,0,1},{2,3,4}}));
    }

    @Test
    void zeroMatrix2() {
        assertArrayEquals((new Integer[][]{}), Question8.zeroMatrix2(new Integer[][]{}));
        assertArrayEquals((new Integer[][]{{24, 12}, {-5, 7}}), Question8.zeroMatrix2(new Integer[][]{{24, 12}, {-5, 7}}));
        assertArrayEquals((new Integer[][]{{0,0},{0,5}}), Question8.zeroMatrix2(new Integer[][]{{0, 8}, {9, 5}}));
        assertArrayEquals((new Integer[][]{{0,0,0},{0,0,0}}), Question8.zeroMatrix2(new Integer[][]{{2, 0, 1}, {3, 5, 0}}));
        assertArrayEquals((new Integer[][]{{0,0,0},{0,0,4},{0,0,0},{0,0,4}}),
                Question8.zeroMatrix2(new Integer[][]{{0,1,3},{10,5,4},{8,0,1},{2,3,4}}));
    }
}