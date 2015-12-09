package com.grspirit.crosszero.model;

import java.util.Arrays;

/**
 * Created by vita on 08.12.15.
 */
public class Field {

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

    public static int MAX_SIZE = 100;
    private int[][] grid;
    private static Field ourInstance = new Field();

    public static Field getInstance() {
        return ourInstance;
    }

    private Field() {
        grid = new int[MAX_SIZE][];
        for (int i = 0; i < MAX_SIZE; i++) {
            grid[i] = new int[MAX_SIZE];
            Arrays.fill(grid[i], 0);
        }
    }

    public void clear() {
        for (int[] row : grid) Arrays.fill(row, 0);
    }

    public void setValue(int x, int y, int value) throws CellIsBusy, IncorrectValue {
        if (value != EMPTY || value != CROSS || value != ZERO)
        if (grid[x][y] != 0)
            throw new CellIsBusy(x, y);
        grid[x][y] = value;
    }

    public int getValue(int x, int y) {
        return grid[x][y];
    }
}
