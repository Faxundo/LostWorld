package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.effect.ModEffects;
import net.faxu.lostworld.enchantment.category.EffectEnchantment;
import net.faxu.lostworld.item.custom.ClubItem;
import net.faxu.lostworld.item.custom.SlingshotItem;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class CaptureEnchantment extends EffectEnchantment {
    public CaptureEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack)
                || stack.getItem() instanceof SlingshotItem;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        int random = Random.create().nextBetween(1, 10);
        if (!user.world.isClient() && target instanceof LivingEntity targetL) {
            Item club = user.getMainHandStack().getItem();
            if (club instanceof ClubItem) {
                random++;
            }
            if (level == 1) {
                if (random >= 10) {
                        targetL.addStatusEffect(new StatusEffectInstance(ModEffects.STUN,
                                40, 0), user);
                }
            }
            if (level == 2) {
                if (random >= 9) {
                        targetL.addStatusEffect(new StatusEffectInstance(ModEffects.STUN,
                                40, 0), user);
                }
            }
            if (level == 3) {
                if (random >= 8) {
                        targetL.addStatusEffect(new StatusEffectInstance(ModEffects.STUN,
                                40, 0), user);
                }
            }
        }
    }
}
