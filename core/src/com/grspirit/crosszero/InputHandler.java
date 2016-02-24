package com.grspirit.crosszero;

import com.badlogic.gdx.InputProcessor;
import com.grspirit.crosszero.view.GridView;

/**
 * Created by vita on 21.02.16.
 */
public class InputHandler implements InputProcessor {
    private GridView gridView;

    public InputHandler(GridView gridView) {
        this.gridView = gridView;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (screenX <= gridView.getScreenWidth() && screenY <= gridView.getScreenHeight())
            gridView.onTouch(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
