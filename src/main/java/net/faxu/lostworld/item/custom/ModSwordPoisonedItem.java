package net.faxu.lostworld.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class ModSwordPoisonedItem extends KnifeItem {

    public ModSwordPoisonedItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 0), attacker);
        stack.damage(2, attacker, (e) -> {e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);});
        return super.postHit(stack, target, attacker);
    }
}
