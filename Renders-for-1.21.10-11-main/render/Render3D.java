package dev.ethan.yog1s.utils.render;

import lombok.experimental.UtilityClass;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexRendering;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import dev.ethan.yog1s.utils.color.ColorUtil;

@UtilityClass
public class Render3D {

    public static void drawOutlinedBox(MatrixStack matrices, VertexConsumer consumer, Box box, int color) {
        MatrixStack.Entry entry = matrices.peek();

        float r = ColorUtil.red(color) / 255f;
        float g = ColorUtil.green(color) / 255f;
        float b = ColorUtil.blue(color) / 255f;
        float a = ColorUtil.alpha(color) / 255f;

        float x1 = (float) box.minX;
        float y1 = (float) box.minY;
        float z1 = (float) box.minZ;
        float x2 = (float) box.maxX;
        float y2 = (float) box.maxY;
        float z2 = (float) box.maxZ;

        drawLine(consumer, entry, x1, y1, z1, x2, y1, z1, r, g, b, a);
        drawLine(consumer, entry, x2, y1, z1, x2, y1, z2, r, g, b, a);
        drawLine(consumer, entry, x2, y1, z2, x1, y1, z2, r, g, b, a);
        drawLine(consumer, entry, x1, y1, z2, x1, y1, z1, r, g, b, a);

        drawLine(consumer, entry, x1, y2, z1, x2, y2, z1, r, g, b, a);
        drawLine(consumer, entry, x2, y2, z1, x2, y2, z2, r, g, b, a);
        drawLine(consumer, entry, x2, y2, z2, x1, y2, z2, r, g, b, a);
        drawLine(consumer, entry, x1, y2, z2, x1, y2, z1, r, g, b, a);

        drawLine(consumer, entry, x1, y1, z1, x1, y2, z1, r, g, b, a);
        drawLine(consumer, entry, x2, y1, z1, x2, y2, z1, r, g, b, a);
        drawLine(consumer, entry, x2, y1, z2, x2, y2, z2, r, g, b, a);
        drawLine(consumer, entry, x1, y1, z2, x1, y2, z2, r, g, b, a);
    }

    public static void drawFilledBox(MatrixStack matrices, VertexConsumer consumer, Box box, int color) {
        float r = ColorUtil.red(color) / 255f;
        float g = ColorUtil.green(color) / 255f;
        float b = ColorUtil.blue(color) / 255f;
        float a = ColorUtil.alpha(color) / 255f;

        VertexRendering.drawFilledBox(
                matrices,
                consumer,
                box.minX, box.minY, box.minZ,
                box.maxX, box.maxY, box.maxZ,
                r, g, b, a
        );
    }


    private static void drawLine(VertexConsumer consumer, MatrixStack.Entry entry,
                                 float x1, float y1, float z1, float x2, float y2, float z2,
                                 float r, float g, float b, float a) {
        float nx = x2 - x1;
        float ny = y2 - y1;
        float nz = z2 - z1;
        float len = MathHelper.sqrt(nx * nx + ny * ny + nz * nz);
        if (len > 0.0001f) {
            nx /= len;
            ny /= len;
            nz /= len;
        } else {
            nx = 0f;
            ny = 1f;
            nz = 0f;
        }

        consumer.vertex(entry, x1, y1, z1).color(r, g, b, a).normal(entry, nx, ny, nz);
        consumer.vertex(entry, x2, y2, z2).color(r, g, b, a).normal(entry, nx, ny, nz);
    }
}
