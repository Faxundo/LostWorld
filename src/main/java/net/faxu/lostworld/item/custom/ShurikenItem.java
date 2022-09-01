package net.faxu.lostworld.item.custom;

import net.faxu.lostworld.entity.custom.IronShurikenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShurikenItem extends Item {

    public ShurikenItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
            user.getItemCooldownManager().set(this, 20);
            IronShurikenEntity ironShurikenEntity = new IronShurikenEntity(world, user);
            ironShurikenEntity.setItem(itemStack);
            ironShurikenEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.7F, 0F);
            world.spawnEntity(ironShurikenEntity);

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
