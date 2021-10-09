package com.freakbox.dragon.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.Pool;

public class AnimationComponent implements Component, Pool.Poolable {
    private final ArrayMap<String, Animation<TextureRegion>> animationMap = new ArrayMap<>();
    private String currentAnimationKey;
    private float animationTime;

    public void addAnimation(String key, Animation<TextureRegion> animation) {
        this.animationMap.put(key, animation);
        if (currentAnimationKey == null)
            currentAnimationKey = key;
    }

    public void setCurrentAnimation(String key) {
        this.currentAnimationKey = key;
        this.animationTime = 0;
    }

    public Animation<TextureRegion> getCurrentAnimation() {
        return animationMap.get(currentAnimationKey);
    }

    public TextureRegion getCurrentFrame() {
        return animationMap.get(currentAnimationKey).getKeyFrame(animationTime);
    }

    public void addAnimationTime(float deltaTime) {
        this.animationTime += deltaTime;
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime = animationTime;
    }

    @Override
    public void reset() {
        animationTime = 0;
    }
}
