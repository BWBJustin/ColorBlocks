package com.bwbjustin.colorblocks.client.colors;

import com.bwbjustin.colorblocks.common.items.ColorBlockItem;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class ColorBlockItemColor implements ItemColor {
    @Override
    public int getColor(ItemStack stack, int tint) {
        if (stack.getItem() instanceof ColorBlockItem) {
            if (!stack.hasTag() || !stack.getTag().contains("color"))
                return 0;
            
            CompoundTag tag = stack.getTag();
            if (tag.contains("color"))
                return tag.getInt("color");
            else
                return 0;
        } else
            return 0;
    }
}
