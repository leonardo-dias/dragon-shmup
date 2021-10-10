package com.freakbox.dragon.entities;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.freakbox.dragon.components.AnimationComponent;
import com.freakbox.dragon.components.BoundsComponent;
import com.freakbox.dragon.components.PlayerShotComponent;
import com.freakbox.dragon.components.TTLComponent;
import com.freakbox.dragon.components.TextureComponent;
import com.freakbox.dragon.components.VelocityComponent;

public class EntityFactory {

    public static Entity createShot(TextureAtlas atlas, PooledEngine engine, float x, float y) {
        Entity shot = engine.createEntity();

        BoundsComponent boundsComponent = engine.createComponent(BoundsComponent.class);
        boundsComponent.bounds.set(x, y, 8, 10);
        shot.add(boundsComponent);

        shot.add(engine.createComponent(PlayerShotComponent.class));

        TextureComponent textureComponent = engine.createComponent(TextureComponent.class);
        textureComponent.x = 0;
        textureComponent.y = 0;
        textureComponent.width = 8;
        textureComponent.height = 10;
        shot.add(textureComponent);

        Animation<TextureRegion> shotAnimation = new Animation<TextureRegion>(0.05f,
                atlas.findRegion("fireball1"),
                atlas.findRegion("fireball2"),
                atlas.findRegion("fireball3"),
                atlas.findRegion("fireball4"));
        shotAnimation.setPlayMode(Animation.PlayMode.LOOP);
        AnimationComponent animationComponent = new AnimationComponent();
        animationComponent.addAnimation("fireball", shotAnimation);
        shot.add(animationComponent);

        VelocityComponent velocityComponent = engine.createComponent(VelocityComponent.class);
        velocityComponent.x = 0;
        velocityComponent.y = 400;
        shot.add(velocityComponent);

        TTLComponent ttlComponent = engine.createComponent(TTLComponent.class);
        ttlComponent.ttl = 2f;
        shot.add(ttlComponent);

        return shot;
    }
}
