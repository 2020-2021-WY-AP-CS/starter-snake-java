package com.battlesnake.wy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloodFillTest {
    @Test
    public void test_numConnected() {
        int[][]walls = {
                // 1 2 3 4 5 6 7 8 9
                {1,1,1,1,1,1,1,1,1,1},  // y = 0
                {1,0,0,0,0,1,0,0,0,1},  // y = 1
                {1,0,0,0,0,1,0,0,0,1},  // y = 2
                {1,0,0,0,0,1,0,0,0,1},
                {1,0,0,0,0,1,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int c = FloodFill.numConnectedSquares(new Posn(6,2), walls);
        assertEquals(12, c);
    }
}
