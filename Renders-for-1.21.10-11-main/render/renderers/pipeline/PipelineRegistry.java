package dev.ethan.yog1s.render.renderers.pipeline;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.util.Identifier;

public final class PipelineRegistry {

    private static VertexFormatElement UV1_ELEMENT;
    private static VertexFormatElement RADIUS_XY_ELEMENT;
    private static VertexFormatElement RADIUS_ZW_ELEMENT;
    private static VertexFormatElement EXTRA_DATA_1_ELEMENT;
    private static VertexFormatElement EXTRA_DATA_2_ELEMENT;
    private static VertexFormatElement RADIUS_ELEMENT;

    private static int getNextVFId() {
        for(int i = 0; i < VertexFormatElement.MAX_COUNT; i++) {
            if (VertexFormatElement.byId(i) == null) return i;
        }
        throw new IllegalStateException("No more free VertexFormatElement slots");
    }

    public static RenderPipeline RECTANGLE_PIPELINE;
    public static RenderPipeline BORDER_PIPELINE;
    public static RenderPipeline TEXTURE_PIPELINE;
    public static RenderPipeline HEAD_TEXTURE_PIPELINE;
    public static RenderPipeline BLUR_PIPELINE;
    public static RenderPipeline JUMP_CIRCLE_PIPELINE;
    public static RenderPipeline ROUND_IMAGE_PIPELINE;

    public static void init() {
        UV1_ELEMENT = VertexFormatElement.register(getNextVFId(), 0, VertexFormatElement.Type.FLOAT, VertexFormatElement.Usage.UV, 2);
        RADIUS_XY_ELEMENT = VertexFormatElement.register(getNextVFId(), 0, VertexFormatElement.Type.FLOAT, VertexFormatElement.Usage.UV, 2);
        RADIUS_ZW_ELEMENT = VertexFormatElement.register(getNextVFId(), 0, VertexFormatElement.Type.FLOAT, VertexFormatElement.Usage.UV, 2);
        EXTRA_DATA_1_ELEMENT = VertexFormatElement.register(getNextVFId(), 0, VertexFormatElement.Type.FLOAT, VertexFormatElement.Usage.UV, 2);
        EXTRA_DATA_2_ELEMENT = VertexFormatElement.register(getNextVFId(), 0, VertexFormatElement.Type.FLOAT, VertexFormatElement.Usage.UV, 2);
        RADIUS_ELEMENT = VertexFormatElement.register(getNextVFId(), 0, VertexFormatElement.Type.FLOAT, VertexFormatElement.Usage.UV, 4);

        // Rectangle Pipeline
        RECTANGLE_PIPELINE = RenderPipelines.register(RenderPipeline.builder(RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET)
                .withLocation(Identifier.of("example", "pipeline/rectangle"))
                .withVertexShader(Identifier.of("example", "core/rectangle"))
                .withFragmentShader(Identifier.of("example", "core/rectangle"))
                .withVertexFormat(VertexFormat.builder()
                        .add("Position", VertexFormatElement.POSITION)
                        .add("UV0", VertexFormatElement.UV0)
                        .add("Color", VertexFormatElement.COLOR)
                        .add("UV1", UV1_ELEMENT)
                        .add("RadiusXY", RADIUS_XY_ELEMENT)
                        .add("RadiusZW", RADIUS_ZW_ELEMENT)
                        .add("ExtraData1", EXTRA_DATA_1_ELEMENT)
                        .build(), VertexFormat.DrawMode.QUADS)
                .withBlend(BlendFunction.TRANSLUCENT)
                .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                .withDepthWrite(false)
                .withCull(false)
                .build()
        );

        // Border Pipeline
        BORDER_PIPELINE = RenderPipelines.register(RenderPipeline.builder(RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET)
                .withLocation(Identifier.of("example", "pipeline/border"))
                .withVertexShader(Identifier.of("example", "core/border"))
                .withFragmentShader(Identifier.of("example", "core/border"))
                .withVertexFormat(VertexFormat.builder()
                        .add("Position", VertexFormatElement.POSITION)
                        .add("UV0", VertexFormatElement.UV0)
                        .add("Color", VertexFormatElement.COLOR)
                        .add("UV1", UV1_ELEMENT)
                        .add("RadiusXY", RADIUS_XY_ELEMENT)
                        .add("RadiusZW", RADIUS_ZW_ELEMENT)
                        .add("BorderData1", EXTRA_DATA_1_ELEMENT)
                        .add("BorderData2", EXTRA_DATA_2_ELEMENT)
                        .build(), VertexFormat.DrawMode.QUADS)
                .withBlend(BlendFunction.TRANSLUCENT)
                .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                .withDepthWrite(false)
                .withCull(false)
                .build()
        );

        // Texture Pipeline
        TEXTURE_PIPELINE = RenderPipelines.register(RenderPipeline.builder(RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET)
                .withLocation(Identifier.of("example", "pipeline/texture"))
                .withVertexShader(Identifier.of("example", "core/texture"))
                .withFragmentShader(Identifier.of("example", "core/texture"))
                .withVertexFormat(VertexFormat.builder()
                        .add("Position", VertexFormatElement.POSITION)
                        .add("UV0", VertexFormatElement.UV0)
                        .add("Color", VertexFormatElement.COLOR)
                        .add("UV1", UV1_ELEMENT)
                        .add("RadiusXY", RADIUS_XY_ELEMENT)
                        .add("RadiusZW", RADIUS_ZW_ELEMENT)
                        .add("ExtraData1", EXTRA_DATA_1_ELEMENT)
                        .build(), VertexFormat.DrawMode.QUADS)
                .withBlend(BlendFunction.TRANSLUCENT)
                .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                .withDepthWrite(false)
                .withCull(false)
                .withSampler("Sampler0")
                .build()
        );

        // Blur Pipeline
        BLUR_PIPELINE = RenderPipelines.register(RenderPipeline.builder(RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET)
                .withLocation(Identifier.of("example", "pipeline/blur"))
                .withVertexShader(Identifier.of("example", "core/blur"))
                .withFragmentShader(Identifier.of("example", "core/blur"))
                .withVertexFormat(VertexFormat.builder()
                        .add("Position", VertexFormatElement.POSITION)
                        .add("UV0", VertexFormatElement.UV0)
                        .add("Color", VertexFormatElement.COLOR)
                        .add("UV1", UV1_ELEMENT)
                        .add("RadiusXY", RADIUS_XY_ELEMENT)
                        .add("RadiusZW", RADIUS_ZW_ELEMENT)
                        .add("BlurData", EXTRA_DATA_1_ELEMENT)
                        .build(), VertexFormat.DrawMode.QUADS)
                .withBlend(BlendFunction.TRANSLUCENT)
                .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                .withDepthWrite(false)
                .withCull(false)
                .withSampler("Sampler0")
                .build()
        );

        // Round Image Pipeline
        ROUND_IMAGE_PIPELINE = RenderPipelines.register(RenderPipeline.builder(RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET)
                .withLocation(Identifier.of("example", "pipeline/round_image"))
                .withVertexShader(Identifier.of("example", "core/round_image"))
                .withFragmentShader(Identifier.of("example", "core/round_image"))
                .withVertexFormat(VertexFormat.builder()
                        .add("Position", VertexFormatElement.POSITION)
                        .add("UV0", VertexFormatElement.UV0)
                        .add("Color", VertexFormatElement.COLOR)
                        .add("UV1", UV1_ELEMENT)
                        .add("RadiusXY", RADIUS_XY_ELEMENT)
                        .add("RadiusZW", RADIUS_ZW_ELEMENT)
                        .add("ExtraData1", EXTRA_DATA_1_ELEMENT)
                        .build(), VertexFormat.DrawMode.QUADS)
                .withBlend(BlendFunction.TRANSLUCENT)
                .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                .withDepthWrite(false)
                .withCull(false)
                .withSampler("Sampler0")
                .build()
        );

    }

    private PipelineRegistry() {}
}
