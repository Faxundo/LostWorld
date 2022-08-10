package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.effect.ModEffects;
import net.faxu.lostworld.item.custom.ClubItem;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class CaptureEnchantment extends Enchantment {
    protected CaptureEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 15 * level;
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateCaptureEnchantment) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != ModEnchantments.BLEEDING
                && !(other instanceof DamageEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.getItem() instanceof ClubItem) {
            return stack.getItem() instanceof ClubItem ? true : super.isAcceptableItem(stack);
        } else {
            return false;
        }
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        int random = Random.create().nextBetween(1, 10);
        if (!user.world.isClient() && target instanceof LivingEntity targetL) {
            if (level == 1) {
                if (random >= 9) {
                        targetL.addStatusEffect(new StatusEffectInstance(ModEffects.STUN,
                                60, 0), user);
                }
            }
            if (level == 2) {
                if (random >= 8) {
                        targetL.addStatusEffect(new StatusEffectInstance(ModEffects.STUN,
                                60, 0), user);
                }
            }
            if (level == 3) {
                if (random >= 7) {
                        targetL.addStatusEffect(new StatusEffectInstance(ModEffects.STUN,
                                60, 0), user);
                }
            }
        }
    }
}
