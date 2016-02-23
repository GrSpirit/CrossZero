package com.grspirit.crosszero.view;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grspirit.crosszero.model.Grid;

/**
 * Created by vita on 23.02.16.
 */
public class GridView {
    private Grid grid;
    private ShapeRenderer shapeRenderer;

    public GridView(Grid grid, ShapeRenderer shapeRenderer) {
        this.grid = grid;
        this.shapeRenderer = shapeRenderer;
    }

    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        for (int i = 0; i < grid.MAX_WIDTH; ++i) {
            for (int j = 0; j < grid.MAX_HEIGHT; ++j) {
                shapeRenderer.rect(i * grid.getCellSize());
            }
        }
    }
}
