package com.protania.orechanger;

import com.protania.orechanger.config.Config;
import com.protania.orechanger.config.CustomVeinLoader;
import com.protania.orechanger.config.data.BlockInformation;
import com.protania.orechanger.config.data.CustomVeinInfo;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod("orechanger")
public class OreChanger
{
    public static final Logger LOGGER = LogManager.getLogger();

    public OreChanger() {
        //Set up config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);

        //Event registry
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void commonSetup (FMLCommonSetupEvent event) {
        CustomVeinLoader.LoadCustomVeinInfo();

        //Remove vanilla ores where applicable
        for (Biome biome : ForgeRegistries.BIOMES) {
            LOGGER.debug("In biome" + biome.getTranslationKey());
            //TODO only touch ores in specified dimensions
            //if (BiomeDictionary.getValues(biome).contains(Type.OVERWORLD) { ... } or something idk
            List<ConfiguredFeature<?, ?>> features = biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES);
            for (int i = 0; i < features.size(); i++) {
                if (Config.COMMON.allowOresNotOverwritten.get()) { //Only remove if custom vein has alternative
                    outermost:
                    for (CustomVeinInfo cvi : CustomVeinLoader.veins) {
                        for (BlockInformation blockInfo : cvi.getBlockInformation()) {
                            Object o = ((DecoratedFeatureConfig)features.get(i).config).feature.config;
                            if (o instanceof OreFeatureConfig) {
                                if ((((OreFeatureConfig)(o)).state.getBlock().matchesBlock(ForgeRegistries.BLOCKS.getValue(blockInfo.getBlock())))) {
                                    LOGGER.info("Removing vanilla ore generation for " + blockInfo.getBlock() + " in biome " + biome.getTranslationKey());
                                    features.remove(i);
                                    break outermost;
                                }
                            }
                        }
                    }
                } else { //Remove regardless lol
                    features.remove(i);
                }
            }
        }

        //Add custom ore features
        //TODO add custom ore features
    }
}