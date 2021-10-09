package com.freakbox.dragon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.freakbox.dragon.components.AnimationComponent;
import com.freakbox.dragon.components.TextureComponent;

public class AnimationSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private ComponentMapper<AnimationComponent> animationComponentMapper = ComponentMapper.getFor(AnimationComponent.class);
    private ComponentMapper<TextureComponent> textureComponentMapper = ComponentMapper.getFor(TextureComponent.class);

    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(AnimationComponent.class, TextureComponent.class).get());
    }

    public void update(float deltaTime) {
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            AnimationComponent animationComponent = animationComponentMapper.get(entity);
            TextureComponent textureComponent = textureComponentMapper.get(entity);

            animationComponent.addAnimationTime(deltaTime);
            textureComponent.textureRegion = animationComponent.getCurrentFrame();
        }
    }
}