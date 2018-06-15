package com.tw;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        int h = 20;
        int w = 20;
        int sleeptime = 1000;
        if (args.length == 3) {
            h = Integer.parseInt(args[0]);
            w = Integer.parseInt(args[1]);
            sleeptime = Integer.parseInt(args[2]);
        }
        Grid grid = new Grid(h, w);
        while (true) {
            System.out.println("----------");
            System.out.print(grid);
            System.out.println("----------");
            grid.nextGenerator();
            Thread.sleep(sleeptime);
        }
    }
}
