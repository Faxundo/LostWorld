package net.faxu.lostworld;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.faxu.lostworld.block.ModBlocks;
import net.faxu.lostworld.entity.ModEntities;
import net.faxu.lostworld.entity.client.GiantBoarRenderer;
import net.faxu.lostworld.entity.client.armor.CopperArmorRenderer;
import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.particle.ModParticles;
import net.faxu.lostworld.particle.custom.BleedingParticle;
import net.faxu.lostworld.particle.custom.StunParticle;
import net.minecraft.client.render.RenderLayer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class LostWorldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(ModParticles.STUN_PARTICLE, StunParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLEEDING_PARTICLE, BleedingParticle.Factory::new);
        GeoArmorRenderer.registerArmorRenderer(new CopperArmorRenderer(), ModItems.COPPER_BOOTS,
                ModItems.COPPER_LEGGINGS, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_HELMET);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BITTER_ROOT_CROP, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntities.WILD_BOAR, GiantBoarRenderer::new);
    }
}
