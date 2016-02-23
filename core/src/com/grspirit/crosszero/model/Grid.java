package com.grspirit.crosszero.model;

import java.util.Arrays;

/**
 * Created by vita on 08.12.15.
 */
public class Grid {

    public static int EMPTY = 0;
    public static int CROSS = 1;
    public static int ZERO = 2;

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
    private int cellSize;
    private int screenWidth, screenHeight;

    public Grid(int screenWidth, int screenHeight) {
        cellSize = (screenWidth / MAX_WIDTH) < (screenHeight / MAX_HEIGHT) ?
                (screenWidth / MAX_WIDTH) : (screenHeight / MAX_HEIGHT);
        this.screenWidth = cellSize * MAX_WIDTH;
        this.screenHeight = cellSize * MAX_HEIGHT;
        grid = new int[MAX_HEIGHT][];
        for (int i = 0; i < MAX_HEIGHT; i++) {
            grid[i] = new int[MAX_WIDTH];
            Arrays.fill(grid[i], 0);
        }
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

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void onClick(int screenX, int screenY) {

    }

    public int getCellSize() {
        return cellSize;
    }

}
