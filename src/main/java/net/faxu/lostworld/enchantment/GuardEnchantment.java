package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class GuardEnchantment extends Enchantment {
    public GuardEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateGuardEnchantment) {
            return 5;
        } else {
            return 0;
        }
    }

    @Override
    public int getMinPower(int level) {
        return 10 * level;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment);
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        if (group == EntityGroup.ILLAGER) {
            return (float)level * 2.5F;
        } else {
            return 0;
        }
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.world.isClient() && target instanceof LivingEntity targetL) {
            if (targetL.getGroup() == EntityGroup.ILLAGER) {
                int i = 20 + user.getRandom().nextInt(10 * level);
                targetL.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, 3));
            }
        }
    }
}
