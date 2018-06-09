package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {
    int height = 100;
    int width = 100;
    private Grid grid = new Grid(height, width);

    @Test
    public void live_number_less_than_2() {

        int input[][] = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        int output[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertArrayEquals(output, grid.nextGenerator(input));

    }


    @Test
    public void shoule_return_center_live_numbers_successfully() {
        int input[][] = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber(input, 1, 1), expectedResult);
    }


    @Test
    public void shoule_return_left_top_live_numbers_successfully() {
        int input[][] = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber(input, 0, 0), expectedResult);
    }


    @Test
    public void shoule_return_right_bottom_live_numbers_successfully() {
        int input[][] = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        int expectedResult = 2;
        assertEquals(grid.getLiveNumber(input, 2, 2), expectedResult);
    }


    @Test
    public void shoule_return_right_top_live_numbers_successfully() {
        int input[][] = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        int expectedResult = 1;
        assertEquals(grid.getLiveNumber(input, 0, 2), expectedResult);
    }


    @Test
    public void should_update_bigger_grid_successfully() {
        int input[][] = {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        int output[][] = {{1, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 1, 0}};
        assertArrayEquals(output, grid.nextGenerator(input));

    }

    @Test
    public void init_grid_and_cell_test() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid.gridCell[i][j].status);
            }
            System.out.println();
        }
    }
}