package com.freakbox.dragon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.freakbox.dragon.components.BoundsComponent;
import com.freakbox.dragon.components.TextureComponent;

public class TextureRenderSystem extends EntitySystem {

    private ImmutableArray<Entity> entities;
    private ComponentMapper<TextureComponent> textureComponentMapper = ComponentMapper.getFor(TextureComponent.class);
    private ComponentMapper<BoundsComponent> boundsComponentMapper = ComponentMapper.getFor(BoundsComponent.class);
    private final SpriteBatch batch;

    public TextureRenderSystem(SpriteBatch batch) {
        this.batch = batch;
    }

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(TextureComponent.class, BoundsComponent.class).get());
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            TextureComponent textureComponent = textureComponentMapper.get(entity);
            BoundsComponent boundsComponent = boundsComponentMapper.get(entity);

            if (textureComponent.textureRegion != null) {
                batch.setColor(textureComponent.color);
                batch.draw(textureComponent.textureRegion,
                        boundsComponent.bounds.x + textureComponent.x,
                        boundsComponent.bounds.y + textureComponent.y,
                        textureComponent.width,
                        textureComponent.height);

                batch.setColor(Color.WHITE);
            }
        }
    }
}