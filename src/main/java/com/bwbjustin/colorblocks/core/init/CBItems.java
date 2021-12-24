package com.bwbjustin.colorblocks.core.init;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.common.items.ColorBlockItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CBItems {
    private CBItems() {}
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ColorBlocks.MOD_ID);
    
    public static final RegistryObject<BlockItem> RAINBOW_BLOCK = ITEMS.register("rainbow_block", () -> new BlockItem(CBBlocks.RAINBOW_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<ColorBlockItem> COLOR_BLOCK = ITEMS.register("color_block", ColorBlockItem::new);
}
