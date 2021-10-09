package com.freakbox.dragon.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.freakbox.dragon.DragonShmupGame;
import com.freakbox.dragon.GameConstants;
import com.freakbox.dragon.entities.Background;
import com.freakbox.dragon.entities.Player;

public class GameScreen implements Screen {

    private final DragonShmupGame game;
    private final SpriteBatch batch;

    private OrthographicCamera camera;
    private Viewport viewport;

    private Background background;
    private Player player;

    public GameScreen (DragonShmupGame game) {
        this.game = game;
        this.batch = game.getBatch();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConstants.WIDTH_PIXELS, GameConstants.HEIGHT_PIXELS, camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);


        background = new Background(game.getAssetManager());
        player = new Player(game.getAssetManager());
        player.getBounds().setX(83);
        player.getBounds().setY(20);

    }

    @Override
    public void render(float delta) {
        camera.update();

        update(delta);

        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw(batch);

        batch.end();
    }

    private void update(float delta) {
        background.update(delta);
        player.update(delta);
    }


    private void draw(SpriteBatch batch) {
        background.draw(batch);
        player.draw(batch);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);

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
