package net.faxu.lostworld.entity.client;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.entity.custom.WildBoarEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class WildBoarModel extends AnimatedGeoModel<WildBoarEntity> {
    @Override
    public Identifier getModelResource(WildBoarEntity object) {
        return new Identifier(LostWorld.MOD_ID, "geo/wild_boar.geo.json");
    }

    @Override
    public Identifier getTextureResource(WildBoarEntity object) {
        return new Identifier(LostWorld.MOD_ID, "textures/entity/wild_boar/wild_boar.png");
    }

    @Override
    public Identifier getAnimationResource(WildBoarEntity animatable) {
        return new Identifier(LostWorld.MOD_ID, "animations/wild_boar.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(WildBoarEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
