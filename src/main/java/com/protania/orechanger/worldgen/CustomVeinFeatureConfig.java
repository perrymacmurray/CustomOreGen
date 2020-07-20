package com.protania.orechanger.worldgen;

import com.mojang.serialization.Codec;
import com.protania.orechanger.config.data.CustomVeinInfo;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class CustomVeinFeatureConfig implements IFeatureConfig {

    public static final Codec<CustomVeinFeatureConfig> codec;
    public static final CustomVeinFeatureConfig config = new CustomVeinFeatureConfig();

    static {
        codec = Codec.unit(() -> {
            return config;
        });
    }

    public boolean enabled; //Only exists to make sure the codec doesn't do anything. How exactly the codec works is an enigma to me
    public CustomVeinInfo info;

    public CustomVeinFeatureConfig() { //Must exist for codec/registry reasons. Just set some default values and hope nothing breaks
        enabled = false;
        info = null;
    }

    public CustomVeinFeatureConfig(CustomVeinInfo cvi) {
        enabled = true;
        info = cvi;
    }
}
