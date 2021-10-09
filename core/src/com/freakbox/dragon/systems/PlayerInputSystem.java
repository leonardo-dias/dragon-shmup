package com.freakbox.dragon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.freakbox.dragon.components.PlayerInputComponent;
import com.freakbox.dragon.components.VelocityComponent;

public class PlayerInputSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private ComponentMapper<PlayerInputComponent> playerInputComponentMapper = ComponentMapper.getFor(PlayerInputComponent.class);
    private ComponentMapper<VelocityComponent> velocityComponentMapper = ComponentMapper.getFor(VelocityComponent.class);

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PlayerInputComponent.class, VelocityComponent.class).get());
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            PlayerInputComponent playerInputComponent = playerInputComponentMapper.get(entity);
            VelocityComponent velocity = velocityComponentMapper.get(entity);
            velocity.x = 0;
            velocity.y = 0;

            if (Gdx.input.isKeyPressed(Input.Keys.W))
                velocity.y += playerInputComponent.velocity;

            if (Gdx.input.isKeyPressed(Input.Keys.S))
                velocity.y -= playerInputComponent.velocity;

            if (Gdx.input.isKeyPressed(Input.Keys.A))
                velocity.x -= playerInputComponent.velocity;

            if (Gdx.input.isKeyPressed(Input.Keys.D))
                velocity.x += playerInputComponent.velocity;
        }
    }
}