package com.bwbjustin.colorblocks.core.init;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.common.menus.SelectColorMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CBMenuTypes {
    private CBMenuTypes() {}
    
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ColorBlocks.MOD_ID);
    
    public static final RegistryObject<MenuType<SelectColorMenu>> SELECT_COLOR_MENU_TYPE = MENU_TYPES.register("select_color", () -> IForgeMenuType.create(SelectColorMenu::new));
}
