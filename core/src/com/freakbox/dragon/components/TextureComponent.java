package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;

public class TextureComponent implements Component, Pool.Poolable {
    public TextureRegion textureRegion;
    public final Color color = new Color(1, 1, 1, 1);
    public float x;
    public float y;
    public float width;
    public float height;

    @Override
    public void reset() {

    }
}
