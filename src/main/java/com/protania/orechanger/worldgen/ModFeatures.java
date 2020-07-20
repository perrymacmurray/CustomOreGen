package com.protania.orechanger.worldgen;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, "orechanger");

    public static final RegistryObject<CustomVeinFeature> VEIN = FEATURES.register("vein", CustomVeinFeature::new);
}
