package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

import java.util.Map;

public class ThornyRosesCurse extends Enchantment {
    protected ThornyRosesCurse() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.FEET,EquipmentSlot.CHEST,
                EquipmentSlot.HEAD,EquipmentSlot.LEGS});
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateThornyRoses) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem || super.isAcceptableItem(stack);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(Enchantments.THORNS, user);
        Random random = user.getRandom();
        if (shouldDamageAttacker(random)) {
            if (attacker != null) {
                attacker.damage(DamageSource.thorns(user), 3.0F);
            }

            if (entry != null) {
                ((ItemStack)entry.getValue()).damage(2, user, (entity) -> {
                    entity.sendEquipmentBreakStatus((EquipmentSlot)entry.getKey());
                });
            }

            if (user instanceof PlayerEntity userP) {
                userP.damage(DamageSource.thorns(userP), 2.0F);
            }
        }
    }

    public static boolean shouldDamageAttacker(Random random) {
        return random.nextFloat() < 0.15F;
    }
}
