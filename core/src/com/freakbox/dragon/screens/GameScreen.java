package com.freakbox.dragon.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.freakbox.dragon.AssetPaths;
import com.freakbox.dragon.DragonShmupGame;
import com.freakbox.dragon.GameConstants;
import com.freakbox.dragon.entities.Player;

public class GameScreen implements Screen {

    private final DragonShmupGame game;
    private final SpriteBatch batch;

    private OrthographicCamera camera;

    private Player player;

    public GameScreen (DragonShmupGame game) {
        this.game = game;
        this.batch = game.getBatch();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(GameConstants.WIDTH_PIXELS, GameConstants.HEIGHT_PIXELS);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        player = new Player(game.getAssetManager().get(AssetPaths.IMAGES_ATLAS, TextureAtlas.class).findRegion("dragon"));
        player.getBounds().setX(83);
        player.getBounds().setY(20);

    }

    @Override
    public void render(float delta) {
        update(delta);

        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw(batch);

        batch.end();
    }

    private void update(float delta) {
        player.update(delta);
    }


    private void draw(SpriteBatch batch) {
        player.draw(batch);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
