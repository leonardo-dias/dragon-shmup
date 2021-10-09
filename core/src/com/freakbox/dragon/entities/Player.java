package com.freakbox.dragon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.freakbox.dragon.AssetPaths;
import com.freakbox.dragon.DragonShmupGame;
import com.freakbox.dragon.GameConstants;

public class Player extends Entity {

    private float velocity = 100;

    private Animation<TextureRegion> dragonAnimation;
    private float animationTime = 0f;

    public Player(AssetManager assetManager) {

        TextureAtlas atlas = assetManager.get(AssetPaths.IMAGES_ATLAS, TextureAtlas.class);

        this.dragonAnimation = new Animation<TextureRegion>(0.1f,
                atlas.findRegion("dragon1"),
                atlas.findRegion("dragon2"),
                atlas.findRegion("dragon3"));
        dragonAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        this.bounds.set(0, 0, 6, 18);
    }

    @Override
    public void update(float delta) {
        animationTime += delta;

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
        batch.draw(dragonAnimation.getKeyFrame(animationTime), bounds.x - 5, bounds.y - 3, 16, 24);
    }
}
