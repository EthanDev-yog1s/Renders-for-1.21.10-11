package dev.ethan.yog1s.render.renderers;

import me.x150.renderer.mixin.DrawContextAccessor;
import me.x150.renderer.render.SimpleGuiRenderState;
import me.x150.renderer.util.DirectVertexConsumer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.texture.TextureSetup;
import org.joml.Matrix3x2fStack;
import dev.ethan.yog1s.render.builders.states.QuadColorState;
import dev.ethan.yog1s.render.builders.states.QuadRadiusState;
import dev.ethan.yog1s.render.builders.states.SizeState;
import dev.ethan.yog1s.render.renderers.pipeline.PipelineRegistry;

public record BorderRenderer(
        SizeState size,
        QuadRadiusState radius,
        QuadColorState color,
        float thickness,
        float internalSmooth,
        float externalSmooth
) implements Renderer {

    private static ScreenRect createBounds(DrawContext c, float x, float y, float w, float h) {
        Matrix3x2fStack mat = c.getMatrices();
        DrawContext.ScissorStack ss = ((DrawContextAccessor) c).getScissorStack();
        ScreenRect scissor = ss.peekLast();

        ScreenRect screenRect = new ScreenRect(
                (int) Math.floor(x),
                (int) Math.floor(y),
                (int) Math.ceil(w),
                (int) Math.ceil(h)
        ).transformEachVertex(mat);

        return scissor != null ? scissor.intersection(screenRect) : screenRect;
    }

    private static float[] colorToFloat(int argb, float opacityPercent) {
        float a = (((argb >> 24) & 0xFF) / 255f) * (opacityPercent / 100f);
        float r = ((argb >> 16) & 0xFF) / 255f;
        float g = ((argb >> 8) & 0xFF) / 255f;
        float b = (argb & 0xFF) / 255f;
        return new float[]{r, g, b, a};
    }

    @Override
    public void render(double x, double y, DrawContext ctx) {
        if (PipelineRegistry.BORDER_PIPELINE == null) return;

        Matrix3x2fStack guiMatrices = ctx.getMatrices();

        SimpleGuiRenderState state = new SimpleGuiRenderState(
                PipelineRegistry.BORDER_PIPELINE,
                TextureSetup.empty(),
                ctx,
                createBounds(ctx, (float) x, (float) y, size.width(), size.height()),
                buffer -> {
                    DirectVertexConsumer dvc = new DirectVertexConsumer((BufferBuilder) buffer, false);

                    float[] c1 = colorToFloat(this.color.color1(), 100);
                    float[] c2 = colorToFloat(this.color.color2(), 100);
                    float[] c3 = colorToFloat(this.color.color3(), 100);
                    float[] c4 = colorToFloat(this.color.color4(), 100);

                 
                    dvc.vertex(guiMatrices, (float) x, (float) y)
                            .texture(0, 0)
                            .color(c1[2], c1[1], c1[0], c1[3])
                            .texture(size.width(), size.height())
                            .texture(radius.radius1(), radius.radius2())
                            .texture(radius.radius3(), radius.radius4())
                            .texture(thickness, internalSmooth)
                            .texture(externalSmooth, 0);

               
                    dvc.vertex(guiMatrices, (float) x, (float) (y + size.height()))
                            .texture(0, 1)
                            .color(c2[2], c2[1], c2[0], c2[3])
                            .texture(size.width(), size.height())
                            .texture(radius.radius1(), radius.radius2())
                            .texture(radius.radius3(), radius.radius4())
                            .texture(thickness, internalSmooth)
                            .texture(externalSmooth, 0);

                  
                    dvc.vertex(guiMatrices, (float) (x + size.width()), (float) (y + size.height()))
                            .texture(1, 1)
                            .color(c3[2], c3[1], c3[0], c3[3])
                            .texture(size.width(), size.height())
                            .texture(radius.radius1(), radius.radius2())
                            .texture(radius.radius3(), radius.radius4())
                            .texture(thickness, internalSmooth)
                            .texture(externalSmooth, 0);

               
                    dvc.vertex(guiMatrices, (float) (x + size.width()), (float) y)
                            .texture(1, 0)
                            .color(c4[2], c4[1], c4[0], c4[3])
                            .texture(size.width(), size.height())
                            .texture(radius.radius1(), radius.radius2())
                            .texture(radius.radius3(), radius.radius4())
                            .texture(thickness, internalSmooth)
                            .texture(externalSmooth, 0);
                }
        );

        ((DrawContextAccessor) ctx).getState().addSimpleElement(state);
    }
}
