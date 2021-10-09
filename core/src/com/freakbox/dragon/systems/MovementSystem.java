package com.freakbox.dragon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.freakbox.dragon.GameConstants;
import com.freakbox.dragon.components.BoundsComponent;
import com.freakbox.dragon.components.VelocityComponent;

public class MovementSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private ComponentMapper<BoundsComponent> boundsComponentMapper = ComponentMapper.getFor(BoundsComponent.class);
    private ComponentMapper<VelocityComponent> velocityComponentMapper = ComponentMapper.getFor(VelocityComponent.class);

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(BoundsComponent.class, VelocityComponent.class).get());
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            BoundsComponent boundsComponent = boundsComponentMapper.get(entity);
            VelocityComponent velocity = velocityComponentMapper.get(entity);

            boundsComponent.bounds.x += velocity.x * deltaTime;
            boundsComponent.bounds.y += velocity.y * deltaTime;

            if (boundsComponent.screenLocked) {
                boundsComponent.bounds.x = MathUtils.clamp(boundsComponent.bounds.x,
                        0, GameConstants.WIDTH_PIXELS - boundsComponent.bounds.width);
                boundsComponent.bounds.y = MathUtils.clamp(boundsComponent.bounds.y,
                        0, GameConstants.HEIGHT_PIXELS - boundsComponent.bounds.height);
            }
        }
    }
}