package net.faxu.lostworld;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.faxu.lostworld.entity.client.armor.CopperArmorRenderer;
import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.particle.ModParticles;
import net.faxu.lostworld.particle.custom.BleedingParticle;
import net.faxu.lostworld.particle.custom.StunParticle;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class LostWorldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.STUN_PARTICLE, StunParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLEEDING_PARTICLE, BleedingParticle.Factory::new);
        GeoArmorRenderer.registerArmorRenderer(new CopperArmorRenderer(), ModItems.COPPER_BOOTS,
                ModItems.COPPER_LEGGINGS, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_HELMET);
    }
}
