package com.grspirit.crosszero.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grspirit.crosszero.X0Game;
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
        int cellSize = grid.getCellSize();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (int i = 0; i < grid.MAX_WIDTH; ++i) {
            for (int j = 0; j < grid.MAX_HEIGHT; ++j) {
                shapeRenderer.setColor(Color.BLACK);
                shapeRenderer.rect(i * cellSize, j * cellSize, (i + 1) * cellSize, (j + 1) * cellSize);
                if (grid.getValue(i, j) == Grid.CROSS) {
                    shapeRenderer.setColor(Color.RED);
                    shapeRenderer.line(i * cellSize + 1, j * cellSize + 1, (i + 1) * cellSize - 1, (j + 1) * cellSize - 1);
                    shapeRenderer.line(i * cellSize + 1, (j + 1) * cellSize - 1, (i + 1) * cellSize - 1, j * cellSize + 1);
                }
                if (grid.getValue(i, j) == Grid.ZERO) {
                    shapeRenderer.setColor(Color.BLUE);
                    shapeRenderer.circle((i + 0.5f) * cellSize, (j + 0.5f) * cellSize, cellSize / 2.0f - 1);
                }
            }
        }
        shapeRenderer.end();
    }
}
