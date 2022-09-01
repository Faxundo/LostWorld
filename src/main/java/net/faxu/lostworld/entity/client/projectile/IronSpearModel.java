package net.faxu.lostworld.entity.client.projectile;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.entity.custom.IronSpearEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IronSpearModel extends AnimatedGeoModel<IronSpearEntity> {

    @Override
    public Identifier getModelResource(IronSpearEntity object) {
        return new Identifier(LostWorld.MOD_ID, "geo/iron_spear.geo.json");
    }
    @Override
    public Identifier getTextureResource(IronSpearEntity object) {
        return new Identifier(LostWorld.MOD_ID, "textures/models/item/iron_spear.png");
    }

    @Override
    public Identifier getAnimationResource(IronSpearEntity animatable) {
        return new Identifier(LostWorld.MOD_ID, "animations/pebble_animation.json");
    }
}
