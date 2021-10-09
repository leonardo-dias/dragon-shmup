package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;

public class BoundsComponent implements Component, Pool.Poolable {

    public final Rectangle bounds = new Rectangle();
    public boolean screenLocked = false;

    @Override
    public void reset() {
    }
}
