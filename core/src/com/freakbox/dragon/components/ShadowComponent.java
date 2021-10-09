package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Pool;

public class ShadowComponent implements Component, Pool.Poolable {

    public final Color color = new Color(0, 0, 0, 0.5f);
    public float x = 0;
    public float y = - 16;

    @Override
    public void reset() {

    }
}
