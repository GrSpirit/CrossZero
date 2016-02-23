package com.grspirit.crosszero;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by vita on 21.02.16.
 */
public class GameRender {
    private GameWorld world;
    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;

    public GameRender(GameWorld world) {
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, X0Game.WIDTH, X0Game.HEIGHT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
    }
}
