package com.freakbox.dragon.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.freakbox.dragon.DragonShmupGame;

public class Player extends Entity {

    private TextureRegion dragonTextureRegion;

    public Player(TextureRegion dragonTextureRegion) {
        this.dragonTextureRegion = dragonTextureRegion;
        this.bounds.set(0, 0, 6, 18);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(dragonTextureRegion, bounds.x - 5, bounds.y - 3, 16, 24);
    }
}
