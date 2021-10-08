package com.freakbox.dragon.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.freakbox.dragon.DragonShmupGame;
import com.freakbox.dragon.GameConstants;

public class GameScreen implements Screen {

    private final DragonShmupGame game;
    private final SpriteBatch batch;

    private OrthographicCamera camera;

    public GameScreen (DragonShmupGame game) {
        this.game = game;
        this.batch = game.getBatch();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(GameConstants.WIDTH_PIXELS, GameConstants.HEIGHT_PIXELS);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();


        batch.end();
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
