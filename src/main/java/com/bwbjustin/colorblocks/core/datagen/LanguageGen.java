package com.bwbjustin.colorblocks.core.datagen;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.core.init.CBBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageGen extends LanguageProvider {
    public LanguageGen(DataGenerator gen, String locale) {
        super(gen, ColorBlocks.MOD_ID, locale);
    }
    
    @Override
    protected void addTranslations() {
        add("itemGroup.color_blocks_tab", "Color Blocks");
        add(CBBlocks.COLOR_BLOCK.get(), "Color Block");
        add("key.select_color", "Select Color");
        add("category.color_blocks", "Color Blocks");
        add("gui.select_color", "Select Color");
        add("gui.select_color.add", "Add 64");
    }
}
