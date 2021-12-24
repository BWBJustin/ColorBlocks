package com.bwbjustin.colorblocks.core.datagen;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.core.init.CBBlocks;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ColorBlocks.MOD_ID, exFileHelper);
    }
    
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(CBBlocks.RAINBOW_BLOCK.get());
        simpleBlock(CBBlocks.COLOR_BLOCK.get(), models()
        .getBuilder(CBBlocks.COLOR_BLOCK.getId().getPath())
        .parent(models().getExistingFile(mcLoc("block/block")))
        .texture("particle", modLoc("block/color_block"))
        .texture("all", modLoc("block/color_block"))
        .element()
            .from(0, 0, 0)
            .to(16, 16, 16)
            .face(Direction.DOWN).uvs(0, 0, 16, 16).texture("#all").cullface(Direction.DOWN).tintindex(0).end()
            .face(Direction.UP).uvs(0, 0, 16, 16).texture("#all").cullface(Direction.UP).tintindex(0).end()
            .face(Direction.NORTH).uvs(0, 0, 16, 16).texture("#all").cullface(Direction.NORTH).tintindex(0).end()
            .face(Direction.SOUTH).uvs(0, 0, 16, 16).texture("#all").cullface(Direction.SOUTH).tintindex(0).end()
            .face(Direction.WEST).uvs(0, 0, 16, 16).texture("#all").cullface(Direction.WEST).tintindex(0).end()
            .face(Direction.EAST).uvs(0, 0, 16, 16).texture("#all").cullface(Direction.EAST).tintindex(0).end()
            .end());
    }
}
