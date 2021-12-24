package com.bwbjustin.colorblocks.core.datagen;

import java.io.IOException;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;

import com.bwbjustin.colorblocks.core.init.CBBlocks;
import com.google.gson.GsonBuilder;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class LootTableGen extends LootTableProvider {
    private DataGenerator generator;
    
    public LootTableGen(DataGenerator gen) {
        super(gen);
        this.generator = gen;
    }
    
    @Override
    public void run(HashCache cache) {
        LootTable table = LootTable.lootTable().withPool(LootPool.lootPool()
        .name(CBBlocks.COLOR_BLOCK.get().getRegistryName().getPath())
        .setRolls(ConstantValue.exactly(1))
        .add(LootItem.lootTableItem(CBBlocks.COLOR_BLOCK.get()))).setParamSet(LootContextParamSets.BLOCK).build();
        
        Path path = generator.getOutputFolder().resolve("data/" + CBBlocks.COLOR_BLOCK.getId().getNamespace() + "/loot_tables/" + CBBlocks.COLOR_BLOCK.getId().getPath() + ".json");
        try {
            DataProvider.save(new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create(), cache, LootTables.serialize(table), path);
        } catch (IOException e) {
            LogManager.getLogger().error("Couldn't write loot table {}", path, e);
        }
    }
}
