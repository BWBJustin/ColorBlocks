package com.bwbjustin.colorblocks.core.init;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.common.entities.ColorBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CBEntityTypes {
    private CBEntityTypes() {}
    
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ColorBlocks.MOD_ID);
    
    public static final RegistryObject<BlockEntityType<ColorBlockEntity>> COLOR_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register("color_block", () ->
        BlockEntityType.Builder.of(ColorBlockEntity::new, CBBlocks.COLOR_BLOCK.get()).build(null)
    );
}
