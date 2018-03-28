package Tests.Chapter1;

import Chapter1.Question7;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Question7Test {

    @Test
    void rotateMatrix() {
        assertArrayEquals((new int[][]{{8,4},{1,2}}), Question7.rotateMatrix(new int[][]{{4,2},{8,1}}));
        assertArrayEquals((new int[][]{{7,3,1},{7,5,0},{4,2,1}}), Question7.rotateMatrix(new int[][]{{1,0,1},{3,5,2},{7,7,4}}));
        assertArrayEquals((new int[][]{{8,0,8,1},{2,1,1,7},{4,9,9,4},{3,1,4,2}}), Question7.rotateMatrix(new int[][]{{1,7,4,2},{8,1,9,4}, {0,1,9,1}, {8,2,4,3}}));
    }

    @Test
    void rotateMatrix2() {
        assertArrayEquals((new int[][]{{8,4},{1,2}}), Question7.rotateMatrix2(new int[][]{{4,2},{8,1}}));
        assertArrayEquals((new int[][]{{7,3,1},{7,5,0},{4,2,1}}), Question7.rotateMatrix2(new int[][]{{1,0,1},{3,5,2},{7,7,4}}));
        assertArrayEquals((new int[][]{{8,0,8,1},{2,1,1,7},{4,9,9,4},{3,1,4,2}}), Question7.rotateMatrix2(new int[][]{{1,7,4,2},{8,1,9,4}, {0,1,9,1}, {8,2,4,3}}));
    }
}