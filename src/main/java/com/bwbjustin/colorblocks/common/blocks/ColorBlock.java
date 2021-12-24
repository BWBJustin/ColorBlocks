package com.bwbjustin.colorblocks.common.blocks;

import com.bwbjustin.colorblocks.common.entities.ColorBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class ColorBlock extends Block implements EntityBlock {
    public ColorBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.8f));
    }
    
    @Override
    public ColorBlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ColorBlockEntity(pos, state);
    }
    
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockEntity entity = level.getBlockEntity(pos);
        if (stack.hasTag() && entity instanceof ColorBlockEntity)
            ((ColorBlockEntity)entity).setColor(stack.getTag().getInt("color"));
    }
}
