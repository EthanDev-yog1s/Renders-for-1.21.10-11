package dev.ethan.yog1s.render.renderers.pipeline;

import lombok.Getter;

public final class PipelineInitializer {

    @Getter
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;
        PipelineRegistry.init();
    }

    private PipelineInitializer() {
    }
}