package net.faxu.lostworld.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public abstract class LostWorldEnchantment extends Enchantment {
    protected LostWorldEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    //For Config Menu (Enable o Disable Enchantments)
    public abstract boolean isEnabled();

    //When Player death
    public void onDeath(int level, ItemStack stack, DamageSource source, LivingEntity user, LivingEntity target){}

    //When Player kill
    public void onKill(int level, ItemStack stack, DamageSource source, LivingEntity killer, LivingEntity victim){}

    //When Item break
    public void onToolBreak(int level, ItemStack stack, PlayerEntity user) {}
}
