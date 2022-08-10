package net.faxu.lostworld.effect;

import net.faxu.lostworld.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

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
        entity.getEntityWorld().addParticle(ModParticles.STUN_PARTICLE,
                entity.getPos().x, entity.getPos().y +1.9d, entity.getPos().z,
                0.25d, 0.35d, 0.25d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
