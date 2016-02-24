package com.grspirit.crosszero;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grspirit.crosszero.view.GridView;

/**
 * Created by vita on 21.02.16.
 */
public class GameRender {
    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private GridView gridView;

    public GameRender(GameWorld world) {
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, X0Game.WIDTH, X0Game.HEIGHT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        gridView = new GridView(world.getGrid(), shapeRenderer, X0Game.WIDTH, X0Game.HEIGHT);
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        gridView.render();
    }

    public GridView getGridView() {
        return gridView;
    }
}
