package com.tw;

public class Grid {
    public int width;
    public int height;

//    public Grid(int w, int h){
//        this.width = w;
//        this.height = h;
//    }
    public int[][] nextGenerator(int[][] input){
        int[][] result = {{0,0,0},{0,0,0},{0,0,0}};
        return result;
    }

    public int getLiveNumber(int[][] input) {
        int w = input.length;
        int h = input[0].length;
        int count = 0;
        if(input[1][0] == 1){
            count++;
        }
        if(input[0][1] == 1){
            count++;
        }
        if(input[1][1] == 1){
            count++;
        }
        return count;
    }
}
