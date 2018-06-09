package com.tw;

import java.util.Random;

public class AmazingEffectUtil {

    int height = 45;
    int width = 45;

    public Cell[][] amazingRandom() {
        Random random = new Random();
        Cell[][] gridCell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridCell[i][j] = new Cell(random.nextInt(10) % 2);
            }
        }
        return gridCell;
    }

    public Cell[][] amazingOne() {
        Cell[][] gridCell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == width / 2 && j > 1 && j < height - 2) {
                    gridCell[i][j] = new Cell(1);
                } else {
                    gridCell[i][j] = new Cell(0);
                }
            }
        }
        return gridCell;
    }

    public Cell[][] amazingTwo() {
        Cell[][] gridCell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == width / 2 && j > 1 && j < height - 2 && j % 5 != 0) {
                    gridCell[i][j] = new Cell(1);
                } else {
                    gridCell[i][j] = new Cell(0);
                }
            }
        }
        return gridCell;
    }


    public Cell[][] amazingThree() {
        Cell[][] gridCell = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0 && j > 1 && j < height - 2) {
                    gridCell[i][j] = new Cell(1);
                } else {
                    gridCell[i][j] = new Cell(0);
                }
            }
        }
        return gridCell;
    }

    public Cell[][] amazing(int amazingNum) {
        Cell[][] gridCell = new Cell[height][width];
        if (amazingNum == 1) {
            gridCell = amazingOne();
        } else if (amazingNum == 2) {
            gridCell = amazingTwo();
        } else if (amazingNum == 3) {
            gridCell = amazingThree();
        } else if (amazingNum == 1) {
            gridCell = amazingRandom();
        }
        return gridCell;
    }
}
