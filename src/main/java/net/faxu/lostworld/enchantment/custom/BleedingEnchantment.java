package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.effect.ModEffects;
import net.faxu.lostworld.enchantment.category.EffectEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.random.Random;

public class BleedingEnchantment extends EffectEnchantment {
    public BleedingEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 15 * level;
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateBleedingEnchantment) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        int random = Random.create().nextBetween(1, 10);
        if (!user.world.isClient() && target instanceof LivingEntity) {
            if (level == 1) {
                if (random >= 8) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,
                            100, 0));
                }
            }
            if (level == 2) {
                if (random >= 7) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,
                            200, 1));
                }
            }
            if (level == 3) {
                if (random >= 6) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,
                            300, 2));
                }
            }
        }
    }
}
