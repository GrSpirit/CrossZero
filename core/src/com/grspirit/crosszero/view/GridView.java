package com.grspirit.crosszero.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grspirit.crosszero.model.Grid;

/**
 * Created by vita on 23.02.16.
 */
public class GridView {
    private Grid grid;
    private ShapeRenderer shapeRenderer;
    private int cellSize;
    private int screenWidth, screenHeight;

    public GridView(Grid grid, ShapeRenderer shapeRenderer, int screenWidth, int screenHeight) {
        this.grid = grid;
        this.shapeRenderer = shapeRenderer;
        cellSize = (screenWidth / Grid.MAX_WIDTH) < (screenHeight / Grid.MAX_HEIGHT) ?
                (screenWidth / Grid.MAX_WIDTH) : (screenHeight / Grid.MAX_HEIGHT);
        this.screenWidth = cellSize * Grid.MAX_WIDTH;
        this.screenHeight = cellSize * Grid.MAX_HEIGHT;
    }

    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (int i = 0; i < grid.MAX_WIDTH; ++i) {
            for (int j = 0; j < grid.MAX_HEIGHT; ++j) {
                shapeRenderer.setColor(Color.BLACK);
                shapeRenderer.rect(i * cellSize, j * cellSize, (i + 1) * cellSize, (j + 1) * cellSize);
                if (grid.getValue(i, j) == Grid.CROSS) {
                    shapeRenderer.setColor(Color.RED);
                    shapeRenderer.line(i * cellSize, j * cellSize, (i + 1) * cellSize, (j + 1) * cellSize);
                    shapeRenderer.line(i * cellSize, (j + 1) * cellSize, (i + 1) * cellSize, j * cellSize);
                }
                if (grid.getValue(i, j) == Grid.ZERO) {
                    shapeRenderer.setColor(Color.BLUE);
                    shapeRenderer.circle((i + 0.5f) * cellSize, (j + 0.5f) * cellSize, cellSize / 2.0f);
                }
            }
        }
        shapeRenderer.end();
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void onTouch(int screenX, int screenY) {
        try {
            grid.onTouch(screenX / cellSize, screenY / cellSize);
        }
        catch (Grid.CellIsBusy e) {

        }
        catch (Grid.IncorrectValue e) {

        }
    }

    public int getCellSize() {
        return cellSize;
    }


}
