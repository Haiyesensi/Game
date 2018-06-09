package com.tw;

import java.util.Random;

public class Grid {
    public Cell[][] gridCell;
    private int height;
    private int width;

    public Grid(int h, int w) {
        this.height = h;
        this.width = w;
        initGrid();
    }

    private void initGrid() {
        Random random = new Random();
        gridCell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridCell[i][j] = new Cell(random.nextInt(10) % 2);
            }
        }
    }

    public int[][] nextGenerator(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int liveNumbers = getLiveNumber(input, i, j);
                if (liveNumbers < 2 || liveNumbers > 3) {
                    result[i][j] = 0;
                } else if (liveNumbers == 3) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = input[i][j];
                }
            }
        }
        return result;
    }

    public int getLiveNumber(int[][] input, int x, int y) {
        int w = input.length;
        int h = input[0].length;
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i < 0 || y + j < 0 || x + i > w - 1 || y + j > h - 1 || (i == 0 && j == 0)) {
                    continue;
                }
                if (input[x + i][y + j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Grid grid = new Grid(100, 100);
    }
}
