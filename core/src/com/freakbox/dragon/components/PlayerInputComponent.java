package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class PlayerInputComponent implements Component, Pool.Poolable {
    public float velocity = 100;

    @Override
    public void reset() {

    }
}
