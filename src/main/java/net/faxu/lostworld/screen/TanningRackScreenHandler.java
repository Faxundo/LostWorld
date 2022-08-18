package net.faxu.lostworld.screen;

import net.faxu.lostworld.screen.slot.ModKnifeSlot;
import net.faxu.lostworld.screen.slot.ModResultSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class TanningRackScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public TanningRackScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(4));
    }

    public TanningRackScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.TANNING_RACK_SCREEN_HANDLER, syncId);
        checkSize(inventory, 4);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new ModKnifeSlot(inventory, 0, 45, 50));
        this.addSlot(new Slot(inventory, 1, 26, 16));
        this.addSlot(new Slot(inventory, 2, 63, 16));
        this.addSlot(new ModResultSlot(inventory, 3, 138, 34));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 91 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 149));
        }
    }
}
