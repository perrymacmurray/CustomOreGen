package com.protania.orechanger.worldgen;

import net.minecraft.util.ResourceLocation;

public class DimensionInformation {
    private String namespace;
    private String dimension;

    public ResourceLocation getDimension() {
        return new ResourceLocation(namespace, dimension);
    }
}