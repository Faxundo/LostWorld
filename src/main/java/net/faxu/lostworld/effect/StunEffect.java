package net.faxu.lostworld.effect;

import net.faxu.lostworld.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StunEffect extends StatusEffect {
    protected StunEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.world.isClient()) {
            entity.teleport(entity.getX(), entity.getY(), entity.getZ());
            entity.setVelocityClient(0, 0, 0);
            entity.setVelocity(0, 0, 0);
        }
        for (int i = 0; i < 360; i++) {
            if (i % 20 == 0) {
                entity.getEntityWorld().addParticle(ModParticles.STUN_PARTICLE,
                        entity.getPos().x, entity.getPos().y +1.8d, entity.getPos().z,
                        Math.cos(i) * 0.25d, 0.35d, Math.sin(i) * 0.25d);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
