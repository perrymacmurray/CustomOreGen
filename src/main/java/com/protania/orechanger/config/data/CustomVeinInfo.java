package com.protania.orechanger.config.data;

import net.minecraft.util.ResourceLocation;

public class CustomVeinInfo {
    private BlockInformation[] blocks;
    private String[] dimensions;
    private int yLevelMax;
    private int yLevelMin;
    private int size;
    private int numPerChunk;

    public BlockInformation[] getBlockInformation() {
        return blocks;
    }

    public ResourceLocation[] getDimensionInformation() {
        ResourceLocation[] resources = new ResourceLocation[dimensions.length];
        for(int i = 0; i < dimensions.length; i++) {
            resources[i] = new ResourceLocation(dimensions[i]);
        }
        return resources;
    }

    public int getYLevelMax() {
        return yLevelMax;
    }

    public int getYLevelMin() {
        return yLevelMin;
    }

    public int getSize() {
        return size;
    }

    public int getNumPerChunk() {
        return numPerChunk;
    }
}
