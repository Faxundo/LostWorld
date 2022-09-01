package net.faxu.lostworld.enchantment.custom;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.enchantment.ModEnchantments;
import net.faxu.lostworld.item.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Map;

public class RustyCurse extends Enchantment {
    public RustyCurse() {
        super(Rarity.RARE, EnchantmentTarget.BREAKABLE, new EquipmentSlot[] {EquipmentSlot.MAINHAND,
                EquipmentSlot.FEET,EquipmentSlot.CHEST,EquipmentSlot.HEAD,EquipmentSlot.LEGS,EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMaxLevel() {
        if(LostWorld.CONFIG.activateRustyCurse) {
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
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(ModEnchantments.RUSTY, user);
        if (entry != null) {
            ((ItemStack)entry.getValue()).damage(1, user, (entity) -> {
                entity.sendEquipmentBreakStatus((EquipmentSlot)entry.getKey());
                if (user instanceof ServerPlayerEntity userP) {
                    ItemStack itemStack = ModItems.SCRAP.getDefaultStack();
                    if (itemStack.getItem() instanceof ArmorItem) {
                        itemStack.setCount(2);
                    } else {
                        itemStack.setCount(1);
                    }
                    userP.getInventory().insertStack(itemStack);
                }
            });
        }
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(ModEnchantments.RUSTY, user);
        if (entry != null) {
            ((ItemStack) entry.getValue()).damage(1, user, (entity) -> {
                entity.sendEquipmentBreakStatus((EquipmentSlot) entry.getKey());
                if (user instanceof ServerPlayerEntity userP) {
                    ItemStack itemStack = ModItems.SCRAP.getDefaultStack();
                    if (itemStack.getItem() instanceof ArmorItem) {
                        itemStack.setCount(2);
                    } else {
                        itemStack.setCount(1);
                    }
                    userP.getInventory().insertStack(itemStack);
                }
            });
        }
    }
}
