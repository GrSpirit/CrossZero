package com.grspirit.crosszero;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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

    public X0Game() {
    }

    @Override
    public void create() {
        this.skin = createSkin();
        this.setScreen(new HelloScreen());
    }

    public void render() {
        super.render();
    }

    public Skin getSkin() {
        return skin;
    }

    public Skin createSkin() {
        skin = new Skin();
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.CORAL);
        pixmap.fill();

        skin.add("coral", pixmap);

        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = skin.newDrawable("coral", Color.DARK_GRAY);
        style.down = skin.newDrawable("coral", Color.DARK_GRAY);
        style.checked = skin.newDrawable("coral", Color.BLUE);
        style.over = skin.newDrawable("coral", Color.LIGHT_GRAY);
        style.font = skin.getFont("default");
        skin.add("default", style);
        return  skin;
    }
}
