package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;

public class ShadowComponent implements Component {

    public final Color color = new Color(0, 0, 0, 0.5f);
    public float x = 0;
    public float y = - 16;
}
