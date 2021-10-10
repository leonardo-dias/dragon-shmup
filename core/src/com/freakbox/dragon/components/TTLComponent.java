package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class TTLComponent implements Component, Pool.Poolable {

    public float ttl = 1;
    public float currentTTl;

    @Override
    public void reset() {
        currentTTl = ttl;
    }
}
