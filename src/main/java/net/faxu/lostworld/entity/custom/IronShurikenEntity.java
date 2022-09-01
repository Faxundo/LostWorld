package net.faxu.lostworld.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.faxu.lostworld.entity.ModEntities;
import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.particle.ModParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class IronShurikenEntity extends ThrownItemEntity {
    public IronShurikenEntity(EntityType<? extends IronShurikenEntity> entityType, World world) {
        super(entityType, world);
    }

    public IronShurikenEntity(World world, LivingEntity owner) {
        super(ModEntities.IRON_SHURIKEN, owner, world);
    }

    public IronShurikenEntity(World world, double x, double y, double z) {
        super(ModEntities.IRON_SHURIKEN, x, y, z, world);
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.IRON_SHURIKEN;
    }

    @Override
    public void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 3F);
        if (entity instanceof LivingEntity livingEntity) {
            addParticle(livingEntity);
        }
    }

    @Environment(EnvType.CLIENT)
    public void addParticle(LivingEntity entity) {
        entity.getEntityWorld().addParticle(ModParticles.HIT_PARTICLE,
                entity.getPos().x + 0.15d, entity.getPos().y + 0.1d, entity.getPos().z + 0.1d,
                0.25d, 0.15d, 0.25d);
    }

    @Override
    public void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)3);
            this.kill();
        }
    }

    @Override
    protected float getGravity() {
        return 0.019F;
    }
//
//    @Override
//    public void setVelocity(double x, double y, double z, float speed, float divergence) {
//        super.setVelocity(x, y, z, speed, divergence);
//    }
}
