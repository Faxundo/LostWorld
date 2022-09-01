package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.enchantment.category.DamageTypeEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class GuardEnchantment extends DamageTypeEnchantment {
    public GuardEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
