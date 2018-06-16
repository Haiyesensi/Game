package com.tw;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.IntStream.range;

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

        if (gridCell == null || gridCell.length == 0) {
            throw new InputInvalidException("input is null or length == 0 !");
        }
        this.height = gridCell.length;
        this.width = gridCell[0].length;
        this.gridCell = gridCell;
    }


    public Grid(int amazingNum) {
        AmazingEffectUtil amazingEffectUtil = new AmazingEffectUtil();
        this.gridCell = amazingEffectUtil.amazing(amazingNum);
        this.height = amazingEffectUtil.height;
        this.width = amazingEffectUtil.width;
    }

    public Cell[][] getGridCell() {
        return gridCell;
    }

    private void initGrid() {
        Random random = new Random();
        gridCell = new Cell[height][width];
        range(0, height).forEach(h -> range(0, width).forEach(w -> gridCell[h][w] = new Cell(random.nextInt(10) % 2)));
    }

    public void nextGenerator() {
        range(0, height).forEach(h -> range(0, width).forEach(w -> gridCell[h][w].setLiveNeighborCount(getLiveNumber(h, w))));
        updateStatus();
    }

    private void updateStatus() {
        range(0, height).forEach(h -> range(0, width).forEach(w -> changeStatus(h, w)));
    }

    private void changeStatus(int i, int j) {
        int liveNumbers = gridCell[i][j].getLiveNeighborCount();
        if (liveNumbers < 2 || liveNumbers > 3) {
            gridCell[i][j].setStatus(0);
        } else if (liveNumbers == 3) {
            gridCell[i][j].setStatus(1);
        }
    }

    public int getLiveNumber(int x, int y) {
        AtomicInteger count = new AtomicInteger();
        range(-1, 2).forEach(h -> range(-1, 2).forEach(w ->{
            if (isWithinRangeAndAlive(x,y,h,w)){
                count.getAndIncrement();
            }
        }));
        return count.get();
    }

    private boolean isWithinRangeAndAlive(int x, int y, int i, int j) {
        boolean result = false;
        if ((x + i < 0 || y + j < 0 || x + i > height - 1 || y + j > width - 1 || (i == 0 && j == 0))) {
            result = false;
        } else if (gridCell[x + i][y + j].getStatus() == 1) {
            result = true;
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        range(0,height).forEach(h -> range(0, width).forEach(w -> {
            if(w == width - 1)result.append("\n");
            result.append(gridCell[h][w].toString() + " ");
        }));
        return result.toString();
    }


}
