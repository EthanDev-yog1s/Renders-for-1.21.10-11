package dev.ethan.yog1s.render.builders;

import dev.ethan.yog1s.render.builders.impl.*;

public final class Builder {

    private static final RectangleBuilder RECTANGLE_BUILDER = new RectangleBuilder();
    private static final BorderBuilder BORDER_BUILDER = new BorderBuilder();
    private static final TextureBuilder TEXTURE_BUILDER = new TextureBuilder();
    private static final HeadTextureBuilder HEAD_TEXTURE_BUILDER = new HeadTextureBuilder();
    private static final BlurBuilder BLUR_BUILDER = new BlurBuilder();
    private static final RoundImageBuilder ROUND_IMAGE_BUILDER = new RoundImageBuilder();

    public static RectangleBuilder rectangle() {
        return RECTANGLE_BUILDER;
    }

    public static BorderBuilder border() {
        return BORDER_BUILDER;
    }

    public static TextureBuilder texture() {
        return TEXTURE_BUILDER;
    }

    public static HeadTextureBuilder headTexture() {
        return HEAD_TEXTURE_BUILDER;
    }

    public static BlurBuilder blur() {
        return BLUR_BUILDER;
    }

    public static RoundImageBuilder roundImage() {
        return ROUND_IMAGE_BUILDER;
    }

}
