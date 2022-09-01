package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.enchantment.category.EffectEnchantment;
import net.faxu.lostworld.item.custom.SpearItem;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;

public class MultipleImpactEnchantment extends EffectEnchantment {
    public MultipleImpactEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.TRIDENT, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 20 * level;
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateMultipleImpact) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SpearItem
                || !(stack.getItem() instanceof TridentItem);
    }
}
