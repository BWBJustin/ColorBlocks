package com.bwbjustin.colorblocks.common.menus;

import com.bwbjustin.colorblocks.core.init.CBItems;
import com.bwbjustin.colorblocks.core.init.CBMenuTypes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

public class SelectColorMenu extends AbstractContainerMenu {
    private SimpleContainer container = new SimpleContainer(1);
    
    public SelectColorMenu(int id, Inventory inventory, FriendlyByteBuf data) {
        super(CBMenuTypes.SELECT_COLOR_MENU_TYPE.get(), id);
        
        addSlot(new Slot(container, 0, 27, 27));
        
        container.setItem(0, CBItems.COLOR_BLOCK.get().getDefaultInstance());
    }
    
    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }
    
    public SimpleContainer getContainer() {
        return container;
    }
    
    public void setContainer(SimpleContainer container) {
        this.container = container;
    }
}
