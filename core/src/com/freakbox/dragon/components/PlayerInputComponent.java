package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class PlayerInputComponent implements Component, Pool.Poolable {
    public float velocity = 100;
    public float shotInterval = 0.2f;
    public float currentShotInterval = 0f;

    @Override
    public void reset() {
        currentShotInterval = 0f;

    }
}
