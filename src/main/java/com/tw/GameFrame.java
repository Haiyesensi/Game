package com.tw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GameFrame extends JFrame {

    private JButton startGameBtn = new JButton("Start Game");
    private JLabel timeStepLabel = new JLabel("             Time Step(ms)");
    private JTextField timeStepTextField = new JTextField();

    private boolean isStart = false;
    private boolean stop = false;

    private JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
    private JPanel gridPanel = new JPanel();
    private JTextField[][] textMatrix;

    private static final int DEFAULT_DURATION = 100;
    private int duration = DEFAULT_DURATION;
    int h = 100;
    int w = 100;
    Grid grid = new Grid(h, w);


    public GameFrame() {
        setTitle("GAME OF LIFE");
        startGameBtn.addActionListener(new StartGameActioner());

        buttonPanel.add(timeStepLabel);
        buttonPanel.add(timeStepTextField);
        buttonPanel.add(startGameBtn);
        buttonPanel.setBackground(Color.WHITE);

        getContentPane().add("North", buttonPanel);

        this.setSize(1600, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void showGrid() {
        for (int i = 0; i < grid.gridCell.length; i++) {
            for (int j = 0; j < grid.gridCell[0].length; j++) {
                if (grid.gridCell[i][j].getStatus() == 1) {
                    textMatrix[i][j].setBackground(Color.BLACK);
                } else {
                    textMatrix[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    private void initGridLayout() {
        int rows = grid.gridCell.length;
        int cols = grid.gridCell[0].length;
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        textMatrix = new JTextField[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JTextField text = new JTextField();
                textMatrix[i][j] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
    }


    private class StartGameActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isStart) {

                initGridLayout();
                //timestep
                try {
                    duration = Integer.parseInt(timeStepTextField.getText().trim());
                } catch (NumberFormatException e1) {
                    duration = DEFAULT_DURATION;
                }

                new Thread(new GameControlTask()).start();
                isStart = true;
                stop = false;
                startGameBtn.setText("Stop Game");
            } else {
                stop = true;
                isStart = false;
                startGameBtn.setText("Start Game");
            }
        }
    }


    private class GameControlTask implements Runnable {
        @Override
        public void run() {
            while (!stop) {
                grid.nextGenerator();
                showGrid();
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

}
