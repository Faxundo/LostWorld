package net.faxu.lostworld.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;

import java.util.UUID;

public class FrozenEffect extends StatusEffect {
    protected FrozenEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public static final UUID FROZEN_UUID = MathHelper.randomUuid(Random.createLocal());

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        EntityAttributeModifier modifier = new EntityAttributeModifier(UUID.fromString("FROZEN_LOSTWORLD"),
                "frozen", -1.0D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        entity.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).addPersistentModifier(modifier);
    }
}
