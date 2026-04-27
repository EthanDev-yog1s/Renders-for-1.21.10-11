package dev.ethan.yog1s.render.builders.impl;

import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import dev.ethan.yog1s.render.builders.AbstractBuilder;
import dev.ethan.yog1s.render.builders.states.QuadColorState;
import dev.ethan.yog1s.render.builders.states.QuadRadiusState;
import dev.ethan.yog1s.render.builders.states.SizeState;
import dev.ethan.yog1s.render.renderers.RoundImageRenderer;

public class RoundImageBuilder extends AbstractBuilder<RoundImageRenderer> {

    private SizeState size;
    private QuadRadiusState radius;
    private QuadColorState color;
    private float smoothness;
    private GpuTextureView texture;

    public RoundImageBuilder size(SizeState size) {
        this.size = size;
        return this;
    }

    public RoundImageBuilder radius(QuadRadiusState radius) {
        this.radius = radius;
        return this;
    }

    public RoundImageBuilder color(QuadColorState color) {
        this.color = color;
        return this;
    }

    public RoundImageBuilder smoothness(float smoothness) {
        this.smoothness = smoothness;
        return this;
    }

    public RoundImageBuilder texture(Identifier resourceLocation) {
        this.texture = MinecraftClient.getInstance()
                .getTextureManager()
                .getTexture(resourceLocation)
                .getGlTextureView();
        return this;
    }

    public RoundImageBuilder texture(GpuTextureView texture) {
        this.texture = texture;
        return this;
    }

    @Override
    protected RoundImageRenderer _build() {
        if (size == null) {
            throw new IllegalStateException("Size must be set");
        }
        if (texture == null) {
            throw new IllegalStateException("Texture must be set");
        }
        return new RoundImageRenderer(size, radius, color, smoothness, texture);
    }

    @Override
    protected void reset() {
        this.size = SizeState.NONE;
        this.radius = QuadRadiusState.NO_ROUND;
        this.color = QuadColorState.WHITE;
        this.smoothness = 1.0f;
        this.texture = null;
    }
}

