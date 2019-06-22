package cn.mcmod.tofucraft.world.biome;

import cn.mcmod.tofucraft.entity.EntityTofuFish;

public class BiomeTofuRiver extends BiomeTofu {
    public BiomeTofuRiver(BiomeProperties property)
    {
        super(property);
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityTofuFish.class, 1, 2, 3));
    }
}
