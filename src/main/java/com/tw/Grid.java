package com.tw;

import java.util.Arrays;
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

    public Grid(Cell[][] gridCell) {
        this.height = gridCell.length;
        this.width = gridCell[0].length;
        this.gridCell = gridCell;
    }

    public Cell[][] getGridCell() {
        return gridCell;
    }

    public void setGridCell(Cell[][] gridCell) {
        this.gridCell = gridCell;
    }

    public Cell[][] CellCopy(Cell[][] gridCell){
        Cell[][] tempGridCell = new Cell[gridCell.length][gridCell[0].length];
        for (int i = 0; i < gridCell.length; i++) {
            for (int j = 0; j < gridCell[0].length; j++) {
                tempGridCell[i][j] = new Cell(gridCell[i][j].status);
            }
        }
        return tempGridCell;
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

    public void nextGenerator() {
        Cell[][] tempGridCell = CellCopy(gridCell);
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                int liveNumbers = getLiveNumber(i, j);
                if (liveNumbers < 2 || liveNumbers > 3) {
                    tempGridCell[i][j].status = 0;
                } else if (liveNumbers == 3) {
                    tempGridCell[i][j].status = 1;
                }
            }
        }
        System.out.println(print(gridCell));
        setGridCell(tempGridCell);
        System.out.println(print(gridCell));
    }

    public int getLiveNumber(int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i < 0 || y + j < 0 || x + i > height - 1 || y + j > width - 1 || (i == 0 && j == 0)) {
                    continue;
                }
                System.out.println(width + " " + height + " " + (i + x) + " " + (j + y));
                if (gridCell[x + i][y + j].status == 1) {
                    count++;
                }
            }
        }
        return count;
    }


    public String print(Cell[][] input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                result.append(input[i][j].toString() + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
