package com.bwbjustin.colorblocks;

import com.bwbjustin.colorblocks.core.init.CBItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ColorBlocksTab extends CreativeModeTab {
    public ColorBlocksTab() {
        super("color_blocks_tab");
    }
    
    @Override
    public ItemStack makeIcon() {
        return CBItems.RAINBOW_BLOCK.get().getDefaultInstance();
    }
}
