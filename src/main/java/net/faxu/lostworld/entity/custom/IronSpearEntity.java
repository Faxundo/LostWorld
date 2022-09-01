package net.faxu.lostworld.entity.custom;

import net.faxu.lostworld.entity.ModEntities;
import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.util.LostWorldEnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class IronSpearEntity extends PersistentProjectileEntity implements IAnimatable {
    private static final TrackedData<Integer> MULTIPLE_IMPACT;
    private static final TrackedData<Boolean> ENCHANTED;
    private int count;
    private ItemStack spearStack;
    private boolean dealtDamage;

    private final AnimationFactory factory = new AnimationFactory(this);

    public IronSpearEntity(EntityType<? extends IronSpearEntity> entityType, World world) {
        super(entityType, world);
        this.spearStack = new ItemStack(ModItems.IRON_SPEAR);
    }

    public IronSpearEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.IRON_SPEAR, owner, world);
        this.spearStack = new ItemStack(ModItems.IRON_SPEAR);
        this.spearStack = stack.copy();
        this.dataTracker.set(MULTIPLE_IMPACT, LostWorldEnchantmentHelper.getMultipleImpact(stack));
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    }

    protected ItemStack asItemStack() {
        return this.spearStack.copy();
    }

    @Nullable
    @Override
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return this.dealtDamage ? null : super.getEntityCollision(currentPosition, nextPosition);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (!(this.hasMultipleImpact())) {
            this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
            entity.damage(DamageSource.trident(this, this.getOwner()), 7.0F);
        }
        if (this.hasMultipleImpact()) {
            int i = this.dataTracker.get(MULTIPLE_IMPACT);
            int impact = this.count++ + i;
            entity.damage(DamageSource.trident(this, this.getOwner()), 7.0F + impact);
            if (impact >= 10) {
                this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

    }

    public boolean hasMultipleImpact() {
        return LostWorldEnchantmentHelper.hasMultipleImpact(this.spearStack);
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (this.isOwner(player) || this.getOwner() == null) {
            super.onPlayerCollision(player);
        }

    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Spear", 10)) {
            this.spearStack = ItemStack.fromNbt(nbt.getCompound("Spear"));
        }
        this.dealtDamage = nbt.getBoolean("DealtDamage");
        this.count = nbt.getInt("Count");
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("Spear", this.spearStack.writeNbt(new NbtCompound()));
        nbt.putBoolean("DealtDamage", this.dealtDamage);
        nbt.putInt("Count", count);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MULTIPLE_IMPACT, 0);
        this.dataTracker.startTracking(ENCHANTED, false);
    }

    @Override
    public void age() {
        if (this.pickupType != PickupPermission.ALLOWED) {
            super.age();
        }
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<IronSpearEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    static {
        MULTIPLE_IMPACT = DataTracker.registerData(IronSpearEntity.class, TrackedDataHandlerRegistry.INTEGER);
        ENCHANTED = DataTracker.registerData(IronSpearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
