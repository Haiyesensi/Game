package com.tw;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid(10, 10);
        while (true) {
            System.out.print(grid);
            grid.nextGenerator();
            Thread.sleep(1000);
        }
    }
}
