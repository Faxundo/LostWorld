package net.faxu.lostworld.item.custom;

import net.faxu.lostworld.entity.custom.CopperArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CopperArrowItem extends ArrowItem {
    public CopperArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new CopperArrowEntity(world, shooter);
    }
}
