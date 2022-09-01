package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.enchantment.category.DamageTypeEnchantment;
import net.faxu.lostworld.item.custom.KnifeItem;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class AssassinateEnchantment extends DamageTypeEnchantment {
    public AssassinateEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateAssassinate) {
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
    public float getAttackDamage(int level, LivingEntity attacker, Entity target, ItemStack stack) {
        if (attacker.isSneaking() || attacker.hasStatusEffect(StatusEffects.INVISIBILITY)) {
            if (stack.getItem() instanceof KnifeItem) {
               return level + 4;
            }
           return level + 2;
        }
        return 0;
    }
}
