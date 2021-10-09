package com.freakbox.dragon.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.freakbox.dragon.components.AnimationComponent;
import com.freakbox.dragon.components.BoundsComponent;
import com.freakbox.dragon.components.PlayerInputComponent;
import com.freakbox.dragon.components.ShadowComponent;
import com.freakbox.dragon.components.TextureComponent;
import com.freakbox.dragon.components.VelocityComponent;

public class Dragon extends Entity {

    public Dragon(float x, float y, TextureAtlas atlas) {
        BoundsComponent boundsComponent = new BoundsComponent();
        boundsComponent.bounds.set(x, y, 6, 18);
        boundsComponent.screenLocked = true;
        add(boundsComponent);

        add(new VelocityComponent());
        add(new PlayerInputComponent());

        TextureComponent textureComponent = new TextureComponent();
        textureComponent.x = -5;
        textureComponent.y = -3;
        textureComponent.width = 16;
        textureComponent.height = 24;
        add(textureComponent);

        Animation<TextureRegion> dragonAnimation = new Animation<TextureRegion>(0.1f,
                atlas.findRegion("dragon1"),
                atlas.findRegion("dragon2"),
                atlas.findRegion("dragon3"));
        dragonAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        AnimationComponent animationComponent = new AnimationComponent();
        animationComponent.addAnimation("dragon", dragonAnimation);
        add(animationComponent);

        ShadowComponent shadowComponent = new ShadowComponent();
        add(shadowComponent);
    }
}
