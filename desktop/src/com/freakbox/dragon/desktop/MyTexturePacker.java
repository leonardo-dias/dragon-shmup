package com.freakbox.dragon.desktop;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class MyTexturePacker {

    private static final String ASSETS_PATH = "./android/assets/images";
    private static final String RAW_ASSETS_PATH = "./desktop/images-raw";
    private static final String PACK_FILENAME = "images";

    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();

        settings.format = Pixmap.Format.RGBA4444;
        settings.filterMin = Texture.TextureFilter.Nearest;
        settings.filterMag = Texture.TextureFilter.Nearest;

        TexturePacker.process(settings, RAW_ASSETS_PATH, ASSETS_PATH, PACK_FILENAME);
    }
}
