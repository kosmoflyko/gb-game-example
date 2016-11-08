package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.PlatformerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PlatformerGame.WIDTH;
		config.height = PlatformerGame.HEIGHT;
		config.title = PlatformerGame.TITLE;
		new LwjglApplication(new PlatformerGame(), config);
	}
}
