package net.faxu.lostworld.entity.client.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.entity.custom.CopperArrowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CopperArrowRenderer extends ProjectileEntityRenderer<CopperArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(LostWorld.MOD_ID,"textures/entity/projectiles/copper_arrow.png");

    public CopperArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(CopperArrowEntity copperArrowEntity) {
        return TEXTURE;
    }

}
