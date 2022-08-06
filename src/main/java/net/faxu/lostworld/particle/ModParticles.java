package net.faxu.lostworld.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.faxu.lostworld.LostWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType BLEEDING_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType STUN_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(LostWorld.MOD_ID, "bleeding_particle"),
                BLEEDING_PARTICLE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(LostWorld.MOD_ID, "stun_particle"),
                STUN_PARTICLE);
    }
}
