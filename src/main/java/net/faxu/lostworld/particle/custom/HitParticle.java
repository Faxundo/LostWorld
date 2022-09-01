package net.faxu.lostworld.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class HitParticle extends SpriteBillboardParticle {

    protected HitParticle(ClientWorld level, double xCoord, double yCoord, double zCoord,
                               SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.velocityMultiplier = 0.4F;
        this.x = xd;
        this.y = yd;
        this.z = zd;
        this.scale = 0.4F;
        this.maxAge = 30;
        this.setSpriteForAge(spriteSet);
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new HitParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    @Override
    public int getBrightness(float tint) {
        return 15728880;
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)maxAge) * age + 1);
    }
}
