package com.protania.orechanger.config.data;

import net.minecraftforge.common.BiomeDictionary;

public class CustomVeinInfo {
    private BlockInformation[] blocks;
    private String[] biomeTypes;
    private int yLevelMax;
    private int yLevelMin;
    private int size;
    private int radius;
    private int numPerChunk;

    public boolean ensureValidity() {
        if (yLevelMax > 255) //Ensure height does not exceed 255
            yLevelMax = 255;
        if (yLevelMin <= 0) //Ensure height does not... inceed... 1
            yLevelMin = 1;

        //Ensure vein exists
        if (size <= 0)
            return false;
        if (radius <= 0)
            return false;
        if (numPerChunk <= 0)
            return false;

        return true;
    }

    public BlockInformation[] getBlockInformation() {
        return blocks;
    }

    public BiomeDictionary.Type[] getBiomeTypeInformation() {
        BiomeDictionary.Type[] types = new BiomeDictionary.Type[biomeTypes.length];
        for(int i = 0; i < biomeTypes.length; i++) {
            types[i] = BiomeDictionary.Type.getType(biomeTypes[i].toUpperCase());
        }
        return types;
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

    public int getRadius() {
        return radius;
    }

    public int getNumPerChunk() {
        return numPerChunk;
    }
}
