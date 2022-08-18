package net.faxu.lostworld.screen.slot;

import net.faxu.lostworld.item.custom.KnifeItem;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class ModKnifeSlot extends Slot {

    public ModKnifeSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof KnifeItem;
    }
}
