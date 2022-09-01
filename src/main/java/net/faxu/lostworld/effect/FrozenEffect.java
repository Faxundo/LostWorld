package net.faxu.lostworld.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class FrozenEffect extends StatusEffect {
    protected FrozenEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public static final UUID FROZEN_UUID = UUID.fromString("10db2c76-5dee-4634-b158-706467727b83");

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.world.isClient()) {
            EntityAttributeInstance attributeInstance = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            if(attributeInstance != null) {
                EntityAttributeModifier modifier = new EntityAttributeModifier(FROZEN_UUID, "FrozenLost",
                        5.0D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
                attributeInstance.removeModifier(modifier);
                attributeInstance.addTemporaryModifier(modifier);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
