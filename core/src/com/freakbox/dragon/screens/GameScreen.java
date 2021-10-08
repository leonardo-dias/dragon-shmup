package com.freakbox.dragon.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.freakbox.dragon.DragonShmupGame;

public class GameScreen implements Screen {

    private final DragonShmupGame game;

    public GameScreen (DragonShmupGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        game.getBatch().begin();
        //game.getBatch().draw(img, 0, 0);
        game.getBatch().end();

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
