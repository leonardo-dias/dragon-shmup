package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class PlayerShotComponent implements Component, Pool.Poolable {

    public boolean active = true;


    @Override
    public void reset() {
        active = true;
    }
}