package com.protania.orechanger.config.data;

import net.minecraftforge.common.BiomeDictionary;

public class CustomVeinInfo {
    private BlockInformation[] blocks;
    private String[] biomeTypes;
    private int yLevelMax;
    private int yLevelMin;
    private int size;
    private int numPerChunk;

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

    public int getNumPerChunk() {
        return numPerChunk;
    }
}
