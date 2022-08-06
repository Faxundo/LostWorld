package net.faxu.lostworld.entity.client.armor;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.item.custom.CopperArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CopperArmorModel extends AnimatedGeoModel<CopperArmorItem> {
    @Override
    public Identifier getModelResource(CopperArmorItem object) {
        return new Identifier(LostWorld.MOD_ID, "geo/copper_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(CopperArmorItem object) {
        return new Identifier(LostWorld.MOD_ID, "textures/models/armor/copper_armor.png");
    }

    @Override
    public Identifier getAnimationResource(CopperArmorItem animatable) {
        return new Identifier(LostWorld.MOD_ID, "animations/armor_animation.json");
    }
}
