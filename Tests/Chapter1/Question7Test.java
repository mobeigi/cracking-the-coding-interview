package Chapter1;

import Chapter1.Question7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Question7Test {

    @Test
    void rotateMatrix() {
        assertArrayEquals((new Integer[][]{{8,4},{1,2}}), Question7.rotateMatrix(new Integer[][]{{4,2},{8,1}}));
        assertArrayEquals((new Integer[][]{{7,3,1},{7,5,0},{4,2,1}}), Question7.rotateMatrix(new Integer[][]{{1,0,1},{3,5,2},{7,7,4}}));
        assertArrayEquals((new Integer[][]{{8,0,8,1},{2,1,1,7},{4,9,9,4},{3,1,4,2}}), Question7.rotateMatrix(new Integer[][]{{1,7,4,2},{8,1,9,4}, {0,1,9,1}, {8,2,4,3}}));
    }

    @Test
    void rotateMatrix2() {
        assertArrayEquals((new Integer[][]{{8,4},{1,2}}), Question7.rotateMatrix2(new Integer[][]{{4,2},{8,1}}));
        assertArrayEquals((new Integer[][]{{7,3,1},{7,5,0},{4,2,1}}), Question7.rotateMatrix2(new Integer[][]{{1,0,1},{3,5,2},{7,7,4}}));
        assertArrayEquals((new Integer[][]{{8,0,8,1},{2,1,1,7},{4,9,9,4},{3,1,4,2}}), Question7.rotateMatrix2(new Integer[][]{{1,7,4,2},{8,1,9,4}, {0,1,9,1}, {8,2,4,3}}));
    }
}