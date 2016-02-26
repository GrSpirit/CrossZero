package com.grspirit.crosszero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grspirit.crosszero.view.GridView;

/**
 * Created by vita on 21.02.16.
 */
public class GameRender {
    private GameWorld world;
    private GridView gridView;

    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;

    public GameRender(GameWorld world) {
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, X0Game.WIDTH, X0Game.HEIGHT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        gridView = new GridView(world.getGrid(), shapeRenderer);
        font = new BitmapFont();
        //font
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        gridView.render();

        if (world.isWin()) {

        }
    }

    public GridView getGridView() {
        return gridView;
    }
}
