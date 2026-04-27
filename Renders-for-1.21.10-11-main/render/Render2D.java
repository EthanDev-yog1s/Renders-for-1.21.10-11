package dev.ethan.yog1s.utils.render;

import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import dev.ethan.yog1s.render.builders.Builder;
import dev.ethan.yog1s.render.builders.states.QuadColorState;
import dev.ethan.yog1s.render.builders.states.QuadRadiusState;
import dev.ethan.yog1s.render.builders.states.SizeState;
import dev.ethan.yog1s.utils.vector.Vector4f;
import dev.ethan.yog1s.utils.vector.Vector4i;


public class Render2D {

    public static void drawRoundRect(DrawContext drawContext, float x, float y, float width, float height, float round, int color) {
        Builder.rectangle()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(round))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundRectOut(DrawContext drawContext, float x, float y, float width, float height, float round, int color, int color2) {
        Builder.rectangle()
                .size(new SizeState(width + 1, height + 1))
                .color(new QuadColorState(color2))
                .radius(new QuadRadiusState(round))
                .build()
                .render(x - 0.5f, y - 0.5f, drawContext);

        Builder.rectangle()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(round))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundRectOut(DrawContext drawContext, float x, float y, float width, float height, Vector4f vector4f, int color, int color2) {
        Builder.rectangle()
                .size(new SizeState(width + 1, height + 1))
                .color(new QuadColorState(color2))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .build()
                .render(x - 0.5f, y - 0.5f, drawContext);

        Builder.rectangle()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundRect(DrawContext drawContext, float x, float y, float width, float height, float round, Vector4i color) {
        Builder.rectangle()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color.getX(), color.getY(), color.getW(), color.getZ()))
                .radius(new QuadRadiusState(round))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawBlurRoundRect(DrawContext drawContext, float x, float y, float width, float height, float round, float smooth, float blur, int color) {
        Builder.blur()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(round))
                .smoothness(smooth)
                .blurRadius(blur)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawBlurRoundRect(DrawContext drawContext, float x, float y, float width, float height, Vector4f vector4f, float smooth, float blur, int color) {
        Builder.blur()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .smoothness(smooth)
                .blurRadius(blur)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawBlurRoundRect(DrawContext drawContext, float x, float y, float width, float height, float round, float smooth, float blur, Vector4i color) {
        Builder.blur()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color.getX(), color.getY(), color.getW(), color.getZ()))
                .radius(new QuadRadiusState(round))
                .smoothness(smooth)
                .blurRadius(blur)
                .build()
                .render(x, y, drawContext);
    }


    public static void drawRoundOutline(DrawContext drawContext, float x, float y, float width, float height, float round, float thickness, int color) {
        Builder.border()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(round))
                .thickness(thickness)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundOutline(DrawContext drawContext, float x, float y, float width, float height, float round, float thickness, float border, Vector4i color) {
        Builder.border()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color.getX(), color.getY(), color.getW(), color.getZ()))
                .radius(new QuadRadiusState(round))
                .thickness(thickness)
                .smoothness(border, border)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundOutline(DrawContext drawContext, float x, float y, float width, float height, Vector4f vector4f, float thickness, float border, Vector4i color) {
        Builder.border()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color.getX(), color.getY(), color.getW(), color.getZ()))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .thickness(thickness)
                .smoothness(border, border)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundOutline(DrawContext drawContext, float x, float y, float width, float height, Vector4f vector4f, float thickness, float border, int color) {
        Builder.border()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .thickness(thickness)
                .smoothness(border, border)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundOutline(DrawContext drawContext, float x, float y, float width, float height, float round, float thickness, Vector4i color) {
        Builder.border()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color.getX(), color.getY(), color.getW(), color.getZ()))
                .radius(new QuadRadiusState(round))
                .thickness(thickness)
                .build()
                .render(x, y, drawContext);
    }
    public static void drawCircle(DrawContext drawContext, float x, float y, float radius, int color) {
        drawRoundRect(drawContext, x - radius / 2f, y - radius / 2f, radius, radius, radius / 2.5f, color);
    }

    public static void drawRoundRect(DrawContext drawContext, float x, float y, float width, float height, Vector4f vector4f, Vector4i color) {
        Builder.rectangle()
                .size(new SizeState(width, height))
                .color(new QuadColorState(color.getX(), color.getY(), color.getW(), color.getZ()))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundRect(DrawContext drawContext, float x, float y, float width, float height, Vector4f vector4f, int color) {
        Builder.rectangle()
                .size(new SizeState(width, height))
                .color(new QuadColorState(
                        color,
                        color,
                        color,
                        color
                ))
                .radius(new QuadRadiusState(vector4f.getX(), vector4f.getY(), vector4f.getW(), vector4f.getZ()))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, float radius, String path) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radius))
                .texture(Identifier.of("example", path))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, float radius, GpuTextureView texture) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radius))
                .texture(texture)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, Vector4f radiusVector, Identifier texture) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radiusVector.getX(), radiusVector.getY(), radiusVector.getW(), radiusVector.getZ()))
                .texture(texture)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, Vector4f radiusVector, GpuTextureView texture) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radiusVector.getX(), radiusVector.getY(), radiusVector.getW(), radiusVector.getZ()))
                .texture(texture)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, float radius, Identifier texture, int color) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radius))
                .texture(texture)
                .color(new QuadColorState(color))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, float radius, GpuTextureView texture, int color) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radius))
                .texture(texture)
                .color(new QuadColorState(color))
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, float radius, float smoothness, Identifier texture) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radius))
                .smoothness(smoothness)
                .texture(texture)
                .build()
                .render(x, y, drawContext);
    }

    public static void drawRoundImage(DrawContext drawContext, float x, float y, float width, float height, float radius, float smoothness, GpuTextureView texture) {
        Builder.roundImage()
                .size(new SizeState(width, height))
                .radius(new QuadRadiusState(radius))
                .smoothness(smoothness)
                .texture(texture)
                .build()
                .render(x, y, drawContext);
    }
}
