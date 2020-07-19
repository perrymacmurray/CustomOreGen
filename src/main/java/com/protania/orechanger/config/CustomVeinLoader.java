package com.protania.orechanger.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.protania.orechanger.OreChanger;
import com.protania.orechanger.worldgen.CustomVeinInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomVeinLoader {

    private static final String CONFIG_PATH = "config/orechanger/";

    public static final List<CustomVeinInfo> veins = new ArrayList<CustomVeinInfo>();

    public static void LoadCustomVeinInfo() {
        OreChanger.LOGGER.info("Loading custom vein information...");
        File config = new File(CONFIG_PATH);
        if (!config.exists())
            config.mkdir();

        Gson gson = new GsonBuilder().create();

        for (File f : config.listFiles()) {
            OreChanger.LOGGER.debug("Loading file " + f.getName());
            try {
                if (f.isDirectory())
                    continue;

                Reader file = new FileReader(f);
                veins.add(gson.fromJson(file, CustomVeinInfo.class));
                file.close();
            } catch (JsonSyntaxException ex) {
                OreChanger.LOGGER.warn("Could not read vein from file " + f.getName() + " - might not be valid.");
            } catch (FileNotFoundException ex) {
                OreChanger.LOGGER.error("File not found - " + f.getName());
            } catch (IOException ex) {
                OreChanger.LOGGER.error(ex.getMessage());
            }
        }
    }
}
