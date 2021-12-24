package com.bwbjustin.colorblocks;

import java.util.function.Supplier;

import com.bwbjustin.colorblocks.common.menus.SelectColorMenu;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

public class InputMessage {
    public static void handle(InputMessage message, Supplier<NetworkEvent.Context> context) {
        NetworkEvent.Context ctx = context.get();
        
        ctx.enqueueWork(() -> {
            MenuProvider provider = new MenuProvider() {
                @Override
                public SelectColorMenu createMenu(int id, Inventory inventory, Player player) {
                    return new SelectColorMenu(id, inventory, null);
                }
                
                @Override
                public Component getDisplayName() {
                    return new TranslatableComponent("gui.select_color");
                }             
            };
            
            NetworkHooks.openGui(ctx.getSender(), provider);
        });
        ctx.setPacketHandled(true);
    }
}
