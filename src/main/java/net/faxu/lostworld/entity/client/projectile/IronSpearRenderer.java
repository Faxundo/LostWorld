package net.faxu.lostworld.entity.client.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.faxu.lostworld.entity.custom.IronSpearEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

@Environment(EnvType.CLIENT)
public class IronSpearRenderer extends GeoProjectilesRenderer<IronSpearEntity> {

    public IronSpearRenderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new IronSpearModel());
    }

    @Override
    public RenderLayer getRenderType(IronSpearEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                     Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureResource(animatable));
    }

}
