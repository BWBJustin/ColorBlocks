package com.bwbjustin.colorblocks.common.entities;

import com.bwbjustin.colorblocks.core.init.CBEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColorBlockEntity extends BlockEntity {
    private int color;
    
    public ColorBlockEntity(BlockPos pos, BlockState state) {
        super(CBEntityTypes.COLOR_BLOCK_ENTITY_TYPE.get(), pos, state);
    }
    
    public int getColor() {
        return color;
    }
    
    public void setColor(int rgb) {
        color = rgb;
        setChanged();
    }
    
    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt("color", getColor());
        return super.save(tag);
    }
    
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        setColor(tag.getInt("color")); 
    }
    
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putInt("color", getColor());
        return tag;
    }
    
    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        setColor(tag.getInt("color"));
    }
    
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("color", getColor());
        return ClientboundBlockEntityDataPacket.create(this);
    }
    
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        setColor(pkt.getTag().getInt("color"));
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 11);
    }
}
