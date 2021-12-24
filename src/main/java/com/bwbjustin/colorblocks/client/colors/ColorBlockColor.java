package com.bwbjustin.colorblocks.client.colors;

import com.bwbjustin.colorblocks.common.entities.ColorBlockEntity;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColorBlockColor implements BlockColor {
    @Override
    public int getColor(BlockState state, BlockAndTintGetter getter, BlockPos pos, int tint) {
        if (getter == null)
            return 0;
        
        BlockEntity entity = getter.getBlockEntity(pos);
        if (entity == null) {
            entity = getter.getBlockEntity(pos.below());
            if (entity == null)
                return 0;
        }
        
        if (entity instanceof ColorBlockEntity)
            return ((ColorBlockEntity)entity).getColor();
        else
            return 0;
    }
}
