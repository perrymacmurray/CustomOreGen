package com.protania.orechanger.config.data;

import net.minecraft.util.ResourceLocation;

public class BlockInformation {
    private String block;
    private int minAmount;
    private int maxAmount;

    public ResourceLocation getBlock() {
        return new ResourceLocation(block);
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }
}