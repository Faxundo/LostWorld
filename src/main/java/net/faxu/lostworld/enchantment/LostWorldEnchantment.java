package net.faxu.lostworld.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public abstract class LostWorldEnchantment extends Enchantment {
    public LostWorldEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    public void onSneaking(int level, PlayerEntity player, ItemStack stack){}

    public float getAttackDamage(int level, LivingEntity attacker, Entity target, ItemStack stack) {
        return 0;
    }
}
