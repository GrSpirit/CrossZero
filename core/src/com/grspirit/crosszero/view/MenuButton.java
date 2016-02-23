package com.grspirit.crosszero.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by vita on 10.12.15.
 */
public class MenuButton extends TextButton {
    TextButton button;

    public MenuButton(String text) {
        //super();
        Skin skin = new Skin();
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

        //button = new TextButton(text, style);
        super(text, skin);
    }

}
