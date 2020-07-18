package com.protania.orechanger;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class OreChangerEventHandler {

    private static OreChangerEventHandler instance = null;

    public static OreChangerEventHandler getInstance() {
        if (instance == null)
            instance = new OreChangerEventHandler();

        return instance;
    }

    @SubscribeEvent
    public void commonSetup (FMLCommonSetupEvent event) {

    }
}
