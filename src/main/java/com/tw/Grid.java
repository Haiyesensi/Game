package com.tw;

public class Grid {
    public int width;
    public int height;

    //    public Grid(int w, int h){
//        this.width = w;
//        this.height = h;
//    }
    public int[][] nextGenerator(int[][] input) {
        int[][] result = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        return result;
    }

    public int getLiveNumber(int[][] input, int x, int y) {
        int w = input.length;
        int h = input[0].length;
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i < 0 || y + j < 0 || x + i > w - 1 || y + j > h - 1) {
                    continue;
                }
                if (i == 0 && j == 0) continue;
                if (input[x + i][y + j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
