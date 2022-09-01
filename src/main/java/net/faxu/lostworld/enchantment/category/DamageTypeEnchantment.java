package net.faxu.lostworld.enchantment.category;

import net.faxu.lostworld.enchantment.LostWorldEnchantment;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class DamageTypeEnchantment extends LostWorldEnchantment {
    public DamageTypeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof DamageTypeEnchantment)
                && !(other instanceof DamageEnchantment);
    }
}