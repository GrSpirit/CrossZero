package com.grspirit.crosszero.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grspirit.crosszero.X0Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = X0Game.WIDTH;
		config.height = X0Game.HEIGHT;
		new LwjglApplication(X0Game.getInstance(), config);
	}
}
