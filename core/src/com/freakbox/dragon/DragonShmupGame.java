package com.freakbox.dragon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.freakbox.dragon.screens.GameScreen;

public class DragonShmupGame extends Game {
	SpriteBatch batch;
	AssetManager assetManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();

		loadAssets();

		this.setScreen(new GameScreen(this));
	}

	private void loadAssets() {
		assetManager.load(AssetPaths.IMAGES_ATLAS, TextureAtlas.class);
		assetManager.finishLoading();
	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
}
