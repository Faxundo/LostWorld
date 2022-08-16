package net.faxu.lostworld.entity.client;

import net.faxu.lostworld.entity.custom.WildBoarEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WildBoarRenderer extends GeoEntityRenderer<WildBoarEntity> {
    public WildBoarRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WildBoarModel());
    }
}
