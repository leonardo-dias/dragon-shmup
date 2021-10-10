package com.freakbox.dragon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.MathUtils;
import com.freakbox.dragon.GameConstants;
import com.freakbox.dragon.components.BoundsComponent;
import com.freakbox.dragon.components.TTLComponent;
import com.freakbox.dragon.components.VelocityComponent;

public class TTLSystem  extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private ComponentMapper<TTLComponent> ttlComponentMapper = ComponentMapper.getFor(TTLComponent.class);


    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(TTLComponent.class).get());
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            TTLComponent ttlComponent = ttlComponentMapper.get(entity);

            ttlComponent.currentTTl -= deltaTime;

            if (ttlComponent.currentTTl <= 0) {
                this.getEngine().removeEntity(entity);
            }
        }
    }
}