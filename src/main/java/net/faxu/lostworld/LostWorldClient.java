package net.faxu.lostworld;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.faxu.lostworld.particle.ModParticles;
import net.faxu.lostworld.particle.custom.BleedingParticle;

public class LostWorldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.BLEEDING_PARTICLE, BleedingParticle.Factory::new);

    }
}
