package com.grspirit.crosszero;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by vita on 10.12.15.
 */
public class X0Game extends Game {
    public static int WIDTH = 800;
    public static int HEIGHT = 480;

    private static X0Game instance = new X0Game();
    private Skin skin;

    public static X0Game getInstance(){
        return instance;
    }

    private X0Game() {
    }

    @Override
    public void create() {
        createSkin();
        this.setScreen(new HelloScreen());
//        this.setScreen(new MainScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    public Skin getSkin() {
        return skin;
    }

    private void createSkin() {
        skin = new Skin();
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.CORAL);
        pixmap.fill();

        Texture coral = new Texture(pixmap);
        skin.add("coral", coral);

        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = skin.newDrawable("coral", Color.DARK_GRAY);
        style.down = skin.newDrawable("coral", Color.DARK_GRAY);
        style.checked = skin.newDrawable("coral", Color.BLUE);
        style.over = skin.newDrawable("coral", Color.LIGHT_GRAY);
        style.font = skin.getFont("default");

        skin.add("default", style);

        Window.WindowStyle windowStyle = new Window.WindowStyle();
        skin.add("default", windowStyle);
    }
}
