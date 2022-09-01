package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.enchantment.category.LootEnchantment;
import net.faxu.lostworld.item.ModItems;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ButcheringEnchantment extends LootEnchantment {
    public ButcheringEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateButcheringEnchantment) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public int getMinPower(int level) {
        return 10 * level;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        super.onTargetDamaged(user, target, level);
        if (!user.world.isClient) {
            if (target instanceof LivingEntity targetL && targetL.getHealth() <= 0) {
                World world = target.getWorld();
                ItemStack itemStack = new ItemStack(ModItems.RAW_MEAT.asItem());
                ItemEntity itemEntity = new ItemEntity(world, target.getX(), target.getY(), target.getZ(), itemStack);
                if (level == 1) {
                    world.spawnEntity(itemEntity);
                }
                if (level == 2) {
                    world.spawnEntity(itemEntity);
                    world.spawnEntity(itemEntity);
                }
                if (level == 3) {
                    world.spawnEntity(itemEntity);
                    world.spawnEntity(itemEntity);
                    world.spawnEntity(itemEntity);
                }
            }
        }
    }
}
