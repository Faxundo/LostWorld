package net.faxu.lostworld.entity.custom;

import net.faxu.lostworld.entity.ModEntities;
import net.faxu.lostworld.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CopperArrowEntity extends PersistentProjectileEntity {
    private int duration = 200;

    public CopperArrowEntity(EntityType<? extends CopperArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public CopperArrowEntity(World world, LivingEntity owner) {
        super(ModEntities.COPPER_ARROW, owner, world);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.COPPER_ARROW);
    }

    @Override
    protected void onHit(LivingEntity target) {
        ServerWorld world = (ServerWorld)target.world;
        BlockPos position = target.getBlockPos();
        int random = Random.createLocal().nextBetween(1, 10);
        if (this.isCritical()) {
            EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                    SpawnReason.TRIGGERED, true, true);
        } else {
            if (random >= 8) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Duration")) {
            this.duration = nbt.getInt("Duration");
        }

    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Duration", this.duration);
    }
}
