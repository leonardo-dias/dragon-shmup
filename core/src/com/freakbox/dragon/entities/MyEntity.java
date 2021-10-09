package com.freakbox.dragon.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class MyEntity {

    protected final Rectangle bounds = new Rectangle();

    public Rectangle getBounds() {
        return bounds;
    }

    public abstract void update(float delta);

    public abstract void draw(SpriteBatch batch);
}
