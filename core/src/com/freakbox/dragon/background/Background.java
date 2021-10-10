package com.freakbox.dragon.background;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.freakbox.dragon.AssetPaths;

public class Background {

    private TextureRegion[] tiles;
    private float tileShift;
    private float velocity = 10;
    private final float TILE_SIZE = 32;

    public Background(AssetManager assetManager) {
        TextureAtlas atlas = assetManager.get(AssetPaths.IMAGES_ATLAS, TextureAtlas.class);
        tiles = new TextureRegion[]{atlas.findRegion("background-tile1"), atlas.findRegion("background-tile2")};
    }

    public void update(float delta) {
        tileShift += velocity * delta;
        if (tileShift > TILE_SIZE * tiles.length)
            tileShift -= TILE_SIZE * tiles.length;
    }

    public void draw(SpriteBatch batch) {

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 10; j++) {
                batch.draw(tiles[(i + j) % 2], i * TILE_SIZE, j * TILE_SIZE - tileShift, TILE_SIZE, TILE_SIZE);
            }

    }
}
