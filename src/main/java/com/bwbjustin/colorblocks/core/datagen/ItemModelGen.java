package com.bwbjustin.colorblocks.core.datagen;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.core.init.CBItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ColorBlocks.MOD_ID, existingFileHelper);
    }
    
    @Override
    protected void registerModels() {
        withExistingParent(CBItems.RAINBOW_BLOCK.getId().getPath(), modLoc("block/rainbow_block"));
        withExistingParent(CBItems.COLOR_BLOCK.getId().getPath(), modLoc("block/color_block"));
    }
}
