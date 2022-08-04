package net.faxu.lostworld.effect;

import net.faxu.lostworld.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.random.Random;

public class BleedingEffect extends StatusEffect {
    protected BleedingEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }



    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.world.isClient()) {
            entity.damage(DamageSource.GENERIC, 1 << amplifier);
        }
        for (int i = 0; i < 360; i++) {
            if (i % 20 == 0) {
                entity.getEntityWorld().addParticle(ModParticles.BLEEDING_PARTICLE,
                        entity.getPos().x, entity.getPos().y + 1, entity.getPos().z,
                        Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == ModEffects.BLEEDING) {
            i = 25 >> amplifier;
            if (i > 4) {
                return duration % i == 0;
            } else {
                return true;
            }
        } else {
            return this == StatusEffects.HUNGER;
        }
    }
}
