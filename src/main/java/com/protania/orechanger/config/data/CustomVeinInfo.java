package com.protania.orechanger.config.data;

public class CustomVeinInfo {
    private BlockInformation[] blocks;
    private DimensionInformation[] dimensions;
    private int yLevelMax;
    private int yLevelMin;
    private int size;

    public BlockInformation[] getBlockInformation() {
        return blocks;
    }

    public DimensionInformation[] getDimensionInformation() {
        return dimensions;
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
}
