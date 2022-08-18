package net.faxu.lostworld.entity.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class WildBoarEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public WildBoarEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 13;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.8f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 1);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this,1.0, false));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0, 0.0F));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wild_boar.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wild_boar.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
