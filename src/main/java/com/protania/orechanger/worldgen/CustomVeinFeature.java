package com.protania.orechanger.worldgen;

import com.protania.orechanger.OreChanger;
import com.protania.orechanger.config.data.BlockInformation;
import com.protania.orechanger.config.data.CustomVeinInfo;
import com.protania.orechanger.util.RandomCollection;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class CustomVeinFeature extends Feature<CustomVeinFeatureConfig> {
    public CustomVeinFeature() {
        super(CustomVeinFeatureConfig.codec);
    }

    private static BlockPos moveDirection(BlockPos origin, int i) {
        BlockPos result;
        switch(i) {
            case 0:
                result = origin.down();
                break;
            case 1:
                result = origin.up();
                break;
            case 2:
                result = origin.north();
                break;
            case 3:
                result = origin.east();
                break;
            case 4:
                result = origin.south();
                break;
            case 5:
                result = origin.west();
                break;
            default:
                result = null;
        }
        return result;
    }

    @Override
    public boolean func_230362_a_(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rand, BlockPos chunkBlockPos, CustomVeinFeatureConfig featureConfig) {
        CustomVeinInfo cvi = featureConfig.info;

        for (int veinNum = 0; veinNum < cvi.getNumPerChunk(); veinNum++) {
            RandomCollection<BlockPos> blocks = new RandomCollection<>(rand);

            BlockPos veinOrigin = new BlockPos(chunkBlockPos).add(rand.nextInt(16), rand.nextInt((cvi.getYLevelMax() - cvi.getSize()) - (cvi.getYLevelMin() + cvi.getSize())) + (cvi.getYLevelMin() + cvi.getSize()), rand.nextInt(16));
            blocks.add(cvi.getRadius(), veinOrigin);

            for (int i = 0; i < cvi.getSize(); i++) {
                veinOrigin = moveDirection(veinOrigin, rand.nextInt(6));
                if (blocks.contains(veinOrigin)) {
                    i--;
                } else {
                    blocks.add(cvi.getRadius(), veinOrigin);
                }
            }

            for (int pass = 1; pass < cvi.getRadius(); pass++) {
                List<BlockPos> discoveredBlocks = new ArrayList<BlockPos>();
                for (Iterator<BlockPos> it = blocks.getIterator(); it.hasNext(); ) {
                    BlockPos b = it.next();
                    for (int i = 0; i < 6; i++) {
                        BlockPos neighbor = moveDirection(b, i);
                        if (!blocks.contains(neighbor) && !discoveredBlocks.contains(neighbor)) {
                            if (neighbor.getY() > 0 && neighbor.getY() <= 255)
                                discoveredBlocks.add(neighbor);
                        }
                    }
                }

                blocks.addAll(cvi.getRadius() - pass, discoveredBlocks);
            }

            for (BlockInformation blockInfo : cvi.getBlockInformation()) {
                for (int i = (rand.nextInt(blockInfo.getMaxAmount() - blockInfo.getMinAmount()) + blockInfo.getMinAmount()); i > 0; i--) {
                    BlockPos selection = blocks.getRandomAndRemove();
                    BlockState currentState = worldIn.getBlockState(selection);
                    //TODO implement target blocks (make default stone)
                    if (currentState.isSolid()) { //Not air or fluid
                        worldIn.setBlockState(selection, ForgeRegistries.BLOCKS.getValue(blockInfo.getBlock()).getDefaultState(), 3);
                    }
                }
            }
        }

        return true;
    }

}
