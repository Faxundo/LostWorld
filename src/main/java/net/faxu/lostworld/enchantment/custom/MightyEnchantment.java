package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.enchantment.category.DamageTypeEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class MightyEnchantment extends DamageTypeEnchantment {
    public MightyEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public boolean isTreasure() {
        return true;
    }

    @Override
    public int getMinPower(int level) {
        return 20 * level;
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
