package com.bwbjustin.colorblocks.core.init;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.common.blocks.ColorBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CBBlocks {
    private CBBlocks() {}
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColorBlocks.MOD_ID);
    
    public static final RegistryObject<Block> RAINBOW_BLOCK = BLOCKS.register("rainbow_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<ColorBlock> COLOR_BLOCK = BLOCKS.register("color_block", ColorBlock::new);
}
