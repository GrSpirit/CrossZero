package com.grspirit.crosszero;

import com.grspirit.crosszero.model.Grid;

/**
 * Created by vita on 21.02.16.
 */
public class GameWorld {
    private Grid grid;
    public GameWorld() {
        grid = new Grid(X0Game.WIDTH, X0Game.HEIGHT);
    }

    public Grid getGrid() {
        return grid;
    }

    public void update() {
        // Do nothing
    }
}
