package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;
import static sun.nio.cs.Surrogate.is;

public class GridTest {
    private Grid grid = new Grid();
    @Test
    public void live_number_less_than_2() {

        int input[][] = {{0,0,0},{0,1,0},{0,1,0}};
        int output[][] = {{0,0,0},{0,0,0},{0,0,0}};
        assertArrayEquals(output,grid.nextGenerator(input));

    }

    @Test
    public void shoule_return_left_top_live_numbers_successfully(){
        int input[][] = {{0,0,0},{0,1,0},{0,1,0}};
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber(input),expectedResult);
    }


}