package com.bwbjustin.colorblocks.common.items;

import java.util.List;

import com.bwbjustin.colorblocks.CSSColors;
import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.core.init.CBBlocks;
import com.bwbjustin.colorblocks.core.init.CBItems;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ColorBlockItem extends BlockItem {
    public ColorBlockItem() {
        super(CBBlocks.COLOR_BLOCK.get(), new Item.Properties().tab(ColorBlocks.COLOR_BLOCKS_TAB));
    }
    
    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        stack.getOrCreateTag().putInt("color", 0);
        return stack;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        
        int color = stack.getOrCreateTag().getInt("color");
        String hex = Integer.toHexString(color).toUpperCase();
        components.add(new TranslatableComponent("#000000".substring(0, 7 - hex.length()) + hex).withStyle(Style.EMPTY.withColor(color)));
    }
    
    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (allowdedIn(tab)) {
            CSSColors.forEach((name, color) -> {
                ItemStack item = new ItemStack(CBItems.COLOR_BLOCK.get());
                CompoundTag tag = item.getOrCreateTag();
                tag.putInt("color", color);
                CompoundTag displayTag = new CompoundTag();
                displayTag.putString("Name", "{\"text\": \"" + name + "\", \"italic\": \"false\"}");
                tag.put("display", displayTag);
                items.add(item);
            });
        }
    }
}
