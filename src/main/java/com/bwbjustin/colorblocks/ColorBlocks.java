package com.bwbjustin.colorblocks;

import com.bwbjustin.colorblocks.client.colors.ColorBlockColor;
import com.bwbjustin.colorblocks.client.colors.ColorBlockItemColor;
import com.bwbjustin.colorblocks.client.screens.SelectColorScreen;
import com.bwbjustin.colorblocks.core.datagen.BlockStateGen;
import com.bwbjustin.colorblocks.core.datagen.BlockTagGen;
import com.bwbjustin.colorblocks.core.datagen.ItemModelGen;
import com.bwbjustin.colorblocks.core.datagen.LanguageGen;
import com.bwbjustin.colorblocks.core.datagen.LootTableGen;
import com.bwbjustin.colorblocks.core.init.CBBlocks;
import com.bwbjustin.colorblocks.core.init.CBEntityTypes;
import com.bwbjustin.colorblocks.core.init.CBItems;
import com.bwbjustin.colorblocks.core.init.CBMenuTypes;
import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod("colorblocks")
public class ColorBlocks {
    public static final String MOD_ID = "colorblocks";
    public static final ColorBlocksTab COLOR_BLOCKS_TAB = new ColorBlocksTab();
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, "main"), () -> "1", "1"::equals, "1"::equals);
    public static final KeyMapping SELECT_COLOR = new KeyMapping("key.select_color", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM.getOrCreate(90), "category.color_blocks");
    
    public ColorBlocks() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::gatherData);
        bus.addListener(this::handleBlockColors);
        bus.addListener(this::handleItemColors);
        bus.addListener(this::setup);
        
        CBBlocks.BLOCKS.register(bus);
        CBItems.ITEMS.register(bus);
        CBEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        CBMenuTypes.MENU_TYPES.register(bus);
        
        MinecraftForge.EVENT_BUS.addListener(this::onTick);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
        CHANNEL.registerMessage(0, InputMessage.class, (message, data) -> {}, data -> new InputMessage(), InputMessage::handle);
    }
    
    private void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        
        if (event.includeServer()) {
            gen.addProvider(new LootTableGen(gen));
            gen.addProvider(new BlockTagGen(gen, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            gen.addProvider(new BlockStateGen(gen, event.getExistingFileHelper()));
            gen.addProvider(new ItemModelGen(gen, event.getExistingFileHelper()));
            gen.addProvider(new LanguageGen(gen, "en_us"));
        }
    }
    
    private void handleBlockColors(ColorHandlerEvent.Block event) {
        event.getBlockColors().register(new ColorBlockColor(), CBBlocks.COLOR_BLOCK.get());
    }
    
    private void handleItemColors(ColorHandlerEvent.Item event) {
        event.getItemColors().register(new ColorBlockItemColor(), CBItems.COLOR_BLOCK.get());
    }
    
    private void onTick(TickEvent.ClientTickEvent event) {
        if (SELECT_COLOR.consumeClick())
            CHANNEL.sendToServer(new InputMessage());
    }
    
    private void setup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(CBMenuTypes.SELECT_COLOR_MENU_TYPE.get(), SelectColorScreen::new));
        ClientRegistry.registerKeyBinding(SELECT_COLOR);
    }
}
