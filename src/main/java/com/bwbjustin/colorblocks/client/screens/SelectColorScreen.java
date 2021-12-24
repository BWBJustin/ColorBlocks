package com.bwbjustin.colorblocks.client.screens;

import com.bwbjustin.colorblocks.ColorBlocks;
import com.bwbjustin.colorblocks.common.menus.SelectColorMenu;
import com.bwbjustin.colorblocks.core.init.CBItems;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SelectColorScreen extends AbstractContainerScreen<SelectColorMenu> {
    private EditBox rEdit;
    private EditBox gEdit;
    private EditBox bEdit;
    private EditBox hEdit;
    private Button add;
    
    public SelectColorScreen(SelectColorMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = 176;
        imageHeight = 70;
    }
    
    protected boolean charCheck(char character) {
        return charCheck(character, false);
    }
    
    protected boolean charCheck(char character, boolean hex) {
        switch (character) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
        }
        
        if (hex) {
            switch (Character.toLowerCase(character)) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        if (rEdit.isFocused()) {
            String previous = rEdit.getValue();
            
            if (!charCheck(codePoint))
                return false;
            
            if (previous.equals("0")) {
                rEdit.setValue(Character.toString(codePoint));
                updateHex();
                return true;
            }
            
            if (Integer.parseInt(previous + codePoint) > 255)
                return false;
            
            if (rEdit.charTyped(codePoint, modifiers)) {
                updateHex();
                return true;
            }
        }
        
        if (gEdit.isFocused()) {
            String previous = gEdit.getValue();
            
            if (!charCheck(codePoint))
                return false;
            
            if (previous.equals("0")) {
                gEdit.setValue(Character.toString(codePoint));
                updateHex();
                return true;
            }
            
            if (Integer.parseInt(previous + codePoint) > 255)
                return false;
            
            if (gEdit.charTyped(codePoint, modifiers)) {
                updateHex();
                return true;
            }
        }
        
        if (bEdit.isFocused()) {
            String previous = bEdit.getValue();
            
            if (!charCheck(codePoint))
                return false;
            
            if (previous.equals("0")) {
                bEdit.setValue(Character.toString(codePoint));
                updateHex();
                return true;
            }
            
            if (Integer.parseInt(previous + codePoint) > 255)
                return false;
            
            if (bEdit.charTyped(codePoint, modifiers)) {
                updateHex();
                return true;
            }
        }
        
        if (hEdit.isFocused()) {
            String previous = hEdit.getValue();
            
            if (!charCheck(codePoint, true))
                return false;
            
            if (hEdit.charTyped(codePoint, modifiers) && previous.startsWith("0")) {
                hEdit.setValue(previous.substring(1, 6) + Character.toUpperCase(codePoint));
                updateRGB();
                return true;
            }
        }
        
        return super.charTyped(codePoint, modifiers);
    }
    
    @Override
    protected void containerTick() {
        super.containerTick();
        rEdit.tick();
        gEdit.tick();
        bEdit.tick();
        hEdit.tick();
    }
    
    @Override
    protected void init() {
        super.init();
        
        rEdit = initializeRGBEditBox(72);
        gEdit = initializeRGBEditBox(100);
        bEdit = initializeRGBEditBox(128);
        hEdit = new EditBox(font, leftPos + 72, topPos + 38, 76, 9, new TranslatableComponent(""));
        hEdit.setMaxLength(6);
        hEdit.setBordered(false);
        hEdit.setValue("000000");
        hEdit.setTextColor(16777215);
        
        add = new Button(leftPos + 4, topPos + 46, 60, 20, new TranslatableComponent("gui.select_color.add"), addBtn -> {
            ItemStack stack = new ItemStack(CBItems.COLOR_BLOCK.get());
            stack.getOrCreateTag().putInt("color", menu.getContainer().getItem(0).getTag().getInt("color"));
            stack.setCount(64);
            minecraft.player.getInventory().add(stack);
        });
        
        addWidget(rEdit);
        addWidget(gEdit);
        addWidget(bEdit);
        addWidget(hEdit);
        addWidget(add);
    }
    
    protected EditBox initializeRGBEditBox(int x) {
        EditBox editBox = new EditBox(font, leftPos + x, topPos + 24, 19, 9, new TranslatableComponent(""));
        editBox.setMaxLength(3);
        editBox.setBordered(false);
        editBox.setValue("0");
        editBox.setTextColor(16777215);
        return editBox;
    }
    
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256)
            minecraft.player.closeContainer();
        
        if (rEdit.isFocused()) {
            String previous = rEdit.getValue();
            
            if (keyCode == 259) {
                if (previous.length() > 1)
                    rEdit.setValue(previous.substring(0, previous.length() - 1));
                else
                    rEdit.setValue("0");
                
                updateHex();
                return true;
            }
            
            return rEdit.keyPressed(keyCode, scanCode, modifiers);
        }
        
        if (gEdit.isFocused()) {
            String previous = gEdit.getValue();
            
            if (keyCode == 259) {
                if (previous.length() > 1)
                    gEdit.setValue(previous.substring(0, previous.length() - 1));
                else
                    gEdit.setValue("0");
                
                updateHex();
                return true;
            }
            
            return gEdit.keyPressed(keyCode, scanCode, modifiers);
        }
        
        if (bEdit.isFocused()) {
            String previous = bEdit.getValue();
            
            if (keyCode == 259) {
                if (previous.length() > 1)
                    bEdit.setValue(previous.substring(0, previous.length() - 1));
                else
                    bEdit.setValue("0");
                
                updateHex();
                return true;
            }
            
            return bEdit.keyPressed(keyCode, scanCode, modifiers);
        }
        
        if (hEdit.isFocused()) {
            String previous = hEdit.getValue();
            
            if (keyCode == 259) {
                hEdit.setValue("0" + previous.substring(0, 5));
                updateRGB();
                return true;
            }
            
            return hEdit.keyPressed(keyCode, scanCode, modifiers);
        }
        
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
    
    @Override
    public void render(PoseStack stack, int mX, int mY, float ticks) {
        renderBackground(stack);
        super.render(stack, mX, mY, ticks);
        renderTooltip(stack, mX, mY);
    }
    
    @Override
    protected void renderBg(PoseStack stack, float ticks, int mX, int mY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, new ResourceLocation(ColorBlocks.MOD_ID, "textures/gui/select_color.png"));
        
        blit(stack, (width - imageWidth) / 2, (height - imageHeight) / 2, 0, 0, imageWidth, imageHeight);
        rEdit.render(stack, mX, mY, ticks);
        gEdit.render(stack, mX, mY, ticks);
        bEdit.render(stack, mX, mY, ticks);
        hEdit.render(stack, mX, mY, ticks);
        add.render(stack, mX, mY, ticks);
    }
    
    @Override
    protected void renderLabels(PoseStack stack, int mX, int mY) {
        font.draw(stack, title, titleLabelX, titleLabelY, 4210752);
        font.draw(stack, new TranslatableComponent("R"), 70, 14, 4210752);
        font.draw(stack, new TranslatableComponent("G"), 98, 14, 4210752);
        font.draw(stack, new TranslatableComponent("B"), 126, 14, 4210752);
        font.draw(stack, new TranslatableComponent("#"), 64, 39, 4210752);
    }
    
    @Override
    protected void slotClicked(Slot slot, int mX, int mY, ClickType type) {}
    
    protected String toHex(int number) {
        String hex = Integer.toString(number, 16).toUpperCase();
        return hex.length() == 1 ? "0" + hex : hex;
    }
    
    protected String toHex(String number) {
        return toHex(Integer.parseInt(number));
    }
    
    protected void updateHex() {
        hEdit.setValue(toHex(rEdit.getValue()) + toHex(gEdit.getValue()) + toHex(bEdit.getValue()));
        updateItemDisplay();
    }
    
    protected void updateItemDisplay() {
        ItemStack stack = new ItemStack(CBItems.COLOR_BLOCK.get());
        stack.getOrCreateTag().putInt("color", Integer.parseInt(hEdit.getValue(), 16));
        menu.getContainer().setItem(0, stack);
    }
    
    protected void updateRGB() {
        rEdit.setValue(Integer.toString(Integer.parseInt(hEdit.getValue().substring(0, 2), 16)));
        gEdit.setValue(Integer.toString(Integer.parseInt(hEdit.getValue().substring(2, 4), 16)));
        bEdit.setValue(Integer.toString(Integer.parseInt(hEdit.getValue().substring(4, 6), 16)));
        updateItemDisplay();
    }
}
