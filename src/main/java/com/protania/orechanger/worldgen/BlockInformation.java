package com.protania.orechanger.worldgen;

import net.minecraft.util.ResourceLocation;

public class BlockInformation {
    private String namespace;
    private String block;
    private int minAmount;
    private int maxAmount;

    public ResourceLocation getBlock() {
        return new ResourceLocation(namespace, block);
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }
}