# CustomOreGen
This is a Minecraft mod that allows for granular, user-configurable overwriting of vanilla ore generation, and that allows for adding entirely new veins of ore into the game.
It can be used for changing the frequency of an existing type of ore, adding a new vein into the game (with multiple different types of ore, if you so desire), and even disabling all ore generation.

##Configuration

This mod uses user-configurable json files to allow for adding new veins of ore into the game. An example of one of these files is as follows:
```json
{
  "blocks": [
    {
	  "block": "minecraft:coal_ore",
      "minAmount": 15,
      "maxAmount": 30
    },
	{
	  "block": "minecraft:diamond_ore",
      "minAmount": 3,
      "maxAmount": 6
    }
  ],
  "biomeTypes": [
    "OVERWORLD"
  ],
  "yLevelMax": 16,
  "yLevelMin": 0,
  "size": 5,
  "radius": 3,
  "numPerChunk": 0.4,
  "targetStone": true
}
```
While most of these fields are self explanatory, certain fields deserve an explanation:
* This mod uses a custom ore generation algorithm through its `CustomVeinFeature` class. As such, the `size` of a vein is how many source blocks are randomly selected in a line. The `radius` is how far out from these source blocks ore can spawn, with a continually decreasing chance.
* `numPerChunk` works with whole numbers, but by adding a decimal, you can reduce spawn rates below 1 per chunk. In the above example, the `numPerChunk` is set to 0.4, meaning that each chunk has a 40% chance of containing a vein. This can also be used for numbers greater than 1: setting `numPerChunk` to 1.5, for example, would mean that a chunk would have at least one vein, with a 50% chance of having a second.
* 'targetStone' is whether or not a vein should spawn within stone (or variant) blocks, like vanilla ore. These variants are: stone, diorite, andesite, and granite.
* `biomeTypes` allows not only for configuring veins to spawn in a specific dimension, but also specific types of biome. For example, you could configure a vein to only spawn in `COLD` biomes. More information on biome types can be found [here](https://skmedix.github.io/ForgeJavaDocs/javadoc/forge/1.9.4-12.17.0.2051/net/minecraftforge/common/BiomeDictionary.Type.html).

---

This mod was created for personal use, but I have no problem with anyone else using it. You don't have to ask for permission to use it in a modpack or anything, should you desire. However, please don't monetize this mod in any way, or deliver it in something locked behind a paywall. Credit me, too.
