package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureComponent implements Component {
    public TextureRegion textureRegion;
    public final Color color = new Color(1, 1, 1, 1);
    public float x;
    public float y;
    public float width;
    public float height;
}
