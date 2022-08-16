package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.effect.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.random.Random;

public class BleedingEnchantment extends Enchantment {
    protected BleedingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
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
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != ModEnchantments.CAPTURE
                && this != other;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        int random = Random.create().nextBetween(1, 10);
        if (!user.world.isClient() && target instanceof LivingEntity) {
            if (level == 1) {
                if (random >= 8) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,
                            5, 0));
                }
            }
            if (level == 2) {
                if (random >= 7) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,
                            10, 1));
                }
            }
            if (level == 3) {
                if (random >= 6) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,
                            15, 2));
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
