package dev.ethan.yog1s.render.builders.impl;

import dev.ethan.yog1s.render.builders.AbstractBuilder;
import dev.ethan.yog1s.render.builders.states.QuadColorState;
import dev.ethan.yog1s.render.builders.states.QuadRadiusState;
import dev.ethan.yog1s.render.builders.states.SizeState;
import dev.ethan.yog1s.render.renderers.BlurRenderer;


public final class BlurBuilder extends AbstractBuilder<BlurRenderer> {


    private SizeState size;
    private QuadRadiusState radius;
    private QuadColorState color;
    private float smoothness;
    private float blurRadius;

    public BlurBuilder size(SizeState size) {
        this.size = size;
        return this;
    }

    public BlurBuilder radius(QuadRadiusState radius) {
        this.radius = radius;
        return this;
    }

    public BlurBuilder color(QuadColorState color) {
        this.color = color;
        return this;
    }

    public BlurBuilder smoothness(float smoothness) {
        this.smoothness = smoothness;
        return this;
    }

    public BlurBuilder blurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
        return this;
    }

    @Override
    protected BlurRenderer _build() {
        return new BlurRenderer(
            this.size,
            this.radius,
            this.color,
            this.smoothness,
            this.blurRadius
        );
    }

    @Override
    protected void reset() {
        this.size = SizeState.NONE;
        this.radius = QuadRadiusState.NO_ROUND;
        this.color = QuadColorState.WHITE;
        this.smoothness = 1.0f;
        this.blurRadius = 0.0f;
    }

}