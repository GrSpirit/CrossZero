package com.grspirit.crosszero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by vita on 10.12.15.
 */
public class HelloScreen implements Screen {

    X0Game game;
    OrthographicCamera camera;
    Stage stage;
    Batch batch;
    ShapeRenderer shapeRenderer;
    TextButton singleModeButton;
    TextButton multiplayerModeButton;

    public HelloScreen() {
        game = X0Game.getInstance();
        stage = new Stage();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, X0Game.WIDTH, X0Game.HEIGHT);
        shapeRenderer = new ShapeRenderer();

        singleModeButton = new TextButton("Single mode", game.getSkin());
        singleModeButton.setPosition(X0Game.WIDTH / 2 - 50, X0Game.HEIGHT * 3 / 4);
        singleModeButton.setWidth(100);
        singleModeButton.setHeight(20);
        multiplayerModeButton = new TextButton("Multi-player", game.getSkin());
        multiplayerModeButton.setPosition(X0Game.WIDTH / 2 - 50, X0Game.HEIGHT * 3 / 4 - 30);
        multiplayerModeButton.setWidth(100);
        multiplayerModeButton.setHeight(20);
        stage.addActor(singleModeButton);
        stage.addActor(multiplayerModeButton);

        singleModeButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainScreen());
                dispose();
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        //shapeRenderer.setProjectionMatrix(camera.combined);
        //shapeRenderer.begin();
        //shapeRenderer.end();
        //stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
