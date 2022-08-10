package net.faxu.lostworld.effect;

import net.faxu.lostworld.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class BleedEffect extends StatusEffect {
    protected BleedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.world.isClient()) {
            entity.damage(DamageSource.GENERIC, 1);
        }
        entity.getEntityWorld().addParticle(ModParticles.BLEEDING_PARTICLE,
                entity.getPos().x , entity.getPos().y + 1.9d, entity.getPos().z,
                0.25d, 0.15d, 0.25d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == ModEffects.BLEED) {
            i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        } else {
            return this == StatusEffects.HUNGER;
        }
    }
}
