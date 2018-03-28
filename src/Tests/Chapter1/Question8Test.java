package Tests.Chapter1;

import Chapter1.Question8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question8Test {

    @Test
    void zeroMatrix() {
        assertArrayEquals((new int[][]{}), Question8.zeroMatrix(new int[][]{}));
        assertArrayEquals((new int[][]{{24, 12}, {-5, 7}}), Question8.zeroMatrix(new int[][]{{24, 12}, {-5, 7}}));
        assertArrayEquals((new int[][]{{0,0},{0,5}}), Question8.zeroMatrix(new int[][]{{0, 8}, {9, 5}}));
        assertArrayEquals((new int[][]{{0,0,0},{0,0,0}}), Question8.zeroMatrix(new int[][]{{2, 0, 1}, {3, 5, 0}}));
        assertArrayEquals((new int[][]{{0,0,0},{0,0,4},{0,0,0},{0,0,4}}),
                Question8.zeroMatrix(new int[][]{{0,1,3},{10,5,4},{8,0,1},{2,3,4}}));
    }
}