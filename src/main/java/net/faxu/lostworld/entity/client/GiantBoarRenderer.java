package net.faxu.lostworld.entity.client;

import net.faxu.lostworld.entity.custom.WildBoarEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GiantBoarRenderer extends GeoEntityRenderer<WildBoarEntity> {
    public GiantBoarRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WildBoarModel());
    }
}
