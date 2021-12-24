package com.bwbjustin.colorblocks.core.datagen;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.core.init.CBBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGen extends BlockTagsProvider {
    public BlockTagGen(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, ColorBlocks.MOD_ID, existingFileHelper);
    }
    
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(CBBlocks.COLOR_BLOCK.get());
    }
}
