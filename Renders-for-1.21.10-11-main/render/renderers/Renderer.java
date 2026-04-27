package dev.ethan.yog1s.render.renderers;

import net.minecraft.client.gui.DrawContext;

public interface Renderer {
    void render(double x, double y, DrawContext context);
}