package com.grspirit.crosszero.model;

import com.grspirit.crosszero.X0Game;

import java.util.Arrays;

/**
 * Created by vita on 08.12.15.
 */
public class Grid {

    public static int EMPTY = 0;
    public static int CROSS = 1;
    public static int ZERO = 2;
    private Player currentPlayer;
    private Player[] players;

    public class CellIsBusy extends Throwable {
        private int x, y;

        public CellIsBusy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public class IncorrectValue extends Throwable {
    }

    public static int MAX_WIDTH = 40;
    public static int MAX_HEIGHT = 20;
    private int[][] grid;

    public Grid() {
        grid = new int[MAX_WIDTH][];
        for (int i = 0; i < MAX_WIDTH; i++) {
            grid[i] = new int[MAX_HEIGHT];
            Arrays.fill(grid[i], 0);
        }

        players = new Player[2];
        players[0] = new Player(CROSS);
        players[1] = new Player(ZERO);
        currentPlayer = players[0];
    }

    public void clear() {
        for (int[] row : grid) Arrays.fill(row, 0);
    }

    public void setValue(int x, int y, int value) throws CellIsBusy, IncorrectValue {
        if ((x < 0 || x >= MAX_WIDTH || y < 0 || y >= MAX_HEIGHT) ||
            (value != EMPTY || value != CROSS || value != ZERO))
                throw new IncorrectValue();
        if (grid[x][y] != 0)
            throw new CellIsBusy(x, y);
        grid[x][y] = value;
    }

    public int getValue(int x, int y) {
        return grid[x][y];
    }

    public void onTouch(int x, int y) throws CellIsBusy, IncorrectValue{
        setValue(x, y, currentPlayer.getFigure());
        currentPlayer = players[(currentPlayer.getFigure() - 1) ^ 1];
    }

    public boolean checkWin(int x, int y) {
        int figure = grid[x][y];

        // Horizontal
        int count = 1;
        for (int i = x - 1; i >= 0; i--) {
            if (getValue(i, y) != figure)
                break;
            count++;
        }
        for (int i = x + 1; i < Grid.MAX_WIDTH; i++) {
            if (getValue(i, y) != figure)
                break;
            count++;
        }

        if (count >= 5) return true;

        // Vertical
        count = 1;
        for (int i = y - 1; i >= 0; i--) {
            if (getValue(x, i) != figure)
                break;
            count++;
        }
        for (int i = y + 1; i < Grid.MAX_HEIGHT; i++) {
            if (getValue(x, i) != figure)
                break;
            count++;
        }
        if (count >= 5) return true;

        // Diagonal1
        count = 1;
        for (int i = 1; (i <= x) && (i <= y); i++) {
            if (getValue(x - i, y - i) != figure)
                break;
            count++;
        }
        for (int i = 1; (i < Grid.MAX_WIDTH) && (i < Grid.MAX_HEIGHT); i++) {
            if (getValue(x + i, y + i) != figure)
                break;
            count++;
        }
        if (count >= 5) return true;

        // Diagonal2
        count = 1;
        for (int i = 1; (i <= x) && (i <= Grid.MAX_HEIGHT); i++) {
            if (getValue(x - i, y + i) != figure)
                break;
            count++;
        }
        for (int i = 1; (i <= y) && (i <= Grid.MAX_WIDTH); i++) {
            if (getValue(x + i, y - i) != figure)
                break;
            count++;
        }
        return (count >= 5);
    }

}
