package com.freakbox.dragon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.freakbox.dragon.components.BoundsComponent;
import com.freakbox.dragon.components.PlayerInputComponent;
import com.freakbox.dragon.entities.EntityFactory;

public class PlayerCreateShotSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;
    private ComponentMapper<PlayerInputComponent> playerInputComponentMapper = ComponentMapper.getFor(PlayerInputComponent.class);
    private ComponentMapper<BoundsComponent> boundsComponentMapper = ComponentMapper.getFor(BoundsComponent.class);

    private TextureAtlas atlas;

    public PlayerCreateShotSystem(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PlayerInputComponent.class, BoundsComponent.class).get());
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            PlayerInputComponent playerInputComponent = playerInputComponentMapper.get(entity);
            BoundsComponent boundsComponent = boundsComponentMapper.get(entity);

            if (playerInputComponent.currentShotInterval <= 0) {
                if (Gdx.input.isKeyPressed(Input.Keys.K)) {
                    createShot(boundsComponent.bounds.x, boundsComponent.bounds.y);
                    playerInputComponent.currentShotInterval += playerInputComponent.shotInterval;
                }
            } else {
                playerInputComponent.currentShotInterval -= deltaTime;
            }
        }
    }

    private void createShot(float x, float y) {
        this.getEngine().addEntity(EntityFactory.createShot(atlas, (PooledEngine) this.getEngine(), x, y));

    }
}