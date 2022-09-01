package net.faxu.lostworld.entity.client.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.faxu.lostworld.LostWorld;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IronShurikenRenderer extends FlyingItemEntityRenderer {

    public static final Identifier TEXTURE = new Identifier(LostWorld.MOD_ID,"textures/item/iron_shuriken.png");

    public IronShurikenRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }
}
