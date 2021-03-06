package com.freakbox.dragon.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.freakbox.dragon.DragonShmupGame;
import com.freakbox.dragon.GameConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameConstants.WIDTH_PIXELS;
		config.height = GameConstants.HEIGHT_PIXELS;

		new LwjglApplication(new DragonShmupGame(), config);
	}
}
