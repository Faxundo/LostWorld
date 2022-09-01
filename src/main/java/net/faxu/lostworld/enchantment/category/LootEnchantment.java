package net.faxu.lostworld.enchantment.category;

import net.faxu.lostworld.enchantment.LostWorldEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class LootEnchantment extends LostWorldEnchantment {
    public LootEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof LootEnchantment)
                && (other != Enchantments.LOOTING);
    }
}
