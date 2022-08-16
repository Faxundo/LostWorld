package net.faxu.lostworld.entity.client.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.faxu.lostworld.entity.custom.PebbleEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

@Environment(EnvType.CLIENT)
public class PebbleRenderer extends GeoProjectilesRenderer<PebbleEntity> {

    public PebbleRenderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new PebbleModel());
    }

    @Override
    public RenderLayer getRenderType(PebbleEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                     Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }
}
