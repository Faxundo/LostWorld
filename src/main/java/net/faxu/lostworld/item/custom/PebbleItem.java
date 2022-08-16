package net.faxu.lostworld.item.custom;

import net.faxu.lostworld.entity.custom.PebbleEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PebbleItem extends ArrowItem {

    public final float damage;

    public PebbleItem(Settings settings, float damageIn) {
        super(settings);
        this.damage = damageIn;
    }

    @Override
    public PebbleEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        PebbleEntity arrowentity = new PebbleEntity(worldIn, shooter, damage);
        arrowentity.setDamage(this.damage);
        return arrowentity;
    }
}
