package com.protania.orechanger;

import com.protania.orechanger.config.Config;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

@Mod("orechanger")
public class OreChanger
{
    public static final Logger LOGGER = LogManager.getLogger();

    public OreChanger() {
        //Set up config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);

        //Set up EventHandler, and rgister self for events for config setup
        MinecraftForge.EVENT_BUS.register(OreChangerEventHandler.getInstance());
    }

}