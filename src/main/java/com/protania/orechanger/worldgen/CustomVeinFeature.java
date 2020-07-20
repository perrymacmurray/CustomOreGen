package com.protania.orechanger.worldgen;

import com.protania.orechanger.config.data.CustomVeinInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class CustomVeinFeature extends Feature<CustomVeinFeatureConfig> {
    public CustomVeinFeature() {
        super(CustomVeinFeatureConfig.codec);
    }

    @Override
    public boolean func_230362_a_(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rand, BlockPos blockPos, CustomVeinFeatureConfig featureConfig) {
        CustomVeinInfo cvi = featureConfig.info;

        //Do things here

        return true;
    }

}
