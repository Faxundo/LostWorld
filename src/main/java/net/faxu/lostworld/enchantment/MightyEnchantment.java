package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class MightyEnchantment extends Enchantment {
    protected MightyEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateMightyEnchantment) {
            return 5;
        } else {
            return 0;
        }
    }

    @Override
    public int getMinPower(int level) {
        return 20 * level;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != ModEnchantments.GUARD
                && !(other instanceof DamageEnchantment);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof PlayerEntity userp) {
            if (userp.experienceLevel > 0) {
                target.damage(DamageSource.MAGIC, (0.1f * level) * userp.experienceLevel);
            }
        }
    }
}
