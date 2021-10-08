package com.freakbox.dragon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.freakbox.dragon.DragonShmupGame;
import com.freakbox.dragon.GameConstants;

public class Player extends Entity {

    private float velocity = 100;

    private TextureRegion dragonTextureRegion;

    public Player(TextureRegion dragonTextureRegion) {
        this.dragonTextureRegion = dragonTextureRegion;
        this.bounds.set(0, 0, 6, 18);
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W))
            this.bounds.y += velocity * delta;

        if (Gdx.input.isKeyPressed(Input.Keys.S))
            this.bounds.y -= velocity * delta;

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            this.bounds.x -= velocity * delta;

        if (Gdx.input.isKeyPressed(Input.Keys.D))
            this.bounds.x += velocity * delta;

        this.bounds.x = MathUtils.clamp(this.bounds.x,
                0, GameConstants.WIDTH_PIXELS - this.bounds.width);
        this.bounds.y = MathUtils.clamp(this.bounds.y,
                0, GameConstants.HEIGHT_PIXELS - this.bounds.height);


    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(dragonTextureRegion, bounds.x - 5, bounds.y - 3, 16, 24);
    }
}
