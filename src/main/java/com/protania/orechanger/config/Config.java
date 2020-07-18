package com.protania.orechanger.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import org.apache.commons.lang3.tuple.Pair;

public class Config {

    public static class Common {
        ForgeConfigSpec.BooleanValue allowOresNotOverwritten;

        public Common(Builder builder) {
            builder.push("worldgen");
            allowOresNotOverwritten = builder
                    .comment("Whether or not the mod allows ores that are not specified to generate. If true, ores where a config is not provided will generate. If false, ONLY ores where a config is provided will generate.")
                    .define("enabled", true);
            builder.pop();
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
