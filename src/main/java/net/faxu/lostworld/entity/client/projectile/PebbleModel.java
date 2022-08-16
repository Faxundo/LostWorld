package net.faxu.lostworld.entity.client.projectile;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.entity.custom.PebbleEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PebbleModel extends AnimatedGeoModel<PebbleEntity> {
    @Override
    public Identifier getModelResource(PebbleEntity object) {
        return new Identifier(LostWorld.MOD_ID, "geo/pebble.geo.json");
    }
    @Override
    public Identifier getTextureResource(PebbleEntity object) {
        return new Identifier(LostWorld.MOD_ID, "textures/models/projectile/pebble.png");
    }

    @Override
    public Identifier getAnimationResource(PebbleEntity animatable) {
        return new Identifier(LostWorld.MOD_ID, "animations/pebble_animation.json");
    }
}
