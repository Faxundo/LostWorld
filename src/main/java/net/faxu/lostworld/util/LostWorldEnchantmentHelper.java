package net.faxu.lostworld.util;

import net.faxu.lostworld.enchantment.LostWorldEnchantment;
import net.faxu.lostworld.enchantment.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.jetbrains.annotations.Nullable;

public class LostWorldEnchantmentHelper {

    public static void onSneaking(PlayerEntity player){
        LostWorldEnchantmentHelper.forEachLostWorldEnchantment((enchantment, level, itemStack) ->
                ((LostWorldEnchantment)enchantment).onSneaking(level, player, itemStack), player.getItemsEquipped());
    }

    public static float getAttackDamage(LivingEntity attacker, Entity target){
        MutableFloat mutableFloat = new MutableFloat();
        ItemStack stack = attacker.getMainHandStack();
        LostWorldEnchantmentHelper.forEachLostWorldEnchantment((enchantment, level, itemStack) ->
                mutableFloat.add(((LostWorldEnchantment)enchantment).getAttackDamage(level, attacker, target, stack)), stack);
        return mutableFloat.floatValue();
    }


    /*
    Si el stack no es nulo o vacío, crea una lista de NBT con cada encantamiento del stack.
    Luego hace un for para recoger toda esa lista y crea un String para sacar el id de cada encantamiento.
    Luego en la variable J guarda el nivel del encantamiento.
    ...
     */
    private static void forEachLostWorldEnchantment(LostWorldEnchantmentHelper.Consumer consumer, ItemStack itemStack) {
        if (itemStack != null && !itemStack.isEmpty()) {
            NbtList NbtList = itemStack.getEnchantments();

            for(int i = 0; i < NbtList.size(); ++i) {
                String string = NbtList.getCompound(i).getString("id");
                int j = NbtList.getCompound(i).getInt("lvl");
                Registry.ENCHANTMENT.getOrEmpty(Identifier.tryParse(string)).ifPresent((enchantment) -> {
                    if(enchantment instanceof LostWorldEnchantment) {
                        consumer.accept((LostWorldEnchantment)enchantment, j, itemStack);
                    }
                });
            }

        }
    }

    private static void forEachLostWorldEnchantment(LostWorldEnchantmentHelper.Consumer consumer, Iterable<ItemStack> stacks) {
        for (ItemStack itemStack : stacks) {
            forEachLostWorldEnchantment(consumer, itemStack);
        }
    }

    public static boolean hasMultipleImpact(ItemStack stack) {
        return getLevel(ModEnchantments.MULTIPLE_IMPACT, stack) > 0;
    }

    public static int getMultipleImpact(ItemStack stack) {
        return getLevel(ModEnchantments.MULTIPLE_IMPACT, stack);
    }

    @Nullable
    public static Identifier getEnchantmentId(Enchantment enchantment) {
        return Registry.ENCHANTMENT.getId(enchantment);
    }

    @Nullable
    public static Identifier getIdFromNbt(NbtCompound nbt) {
        return Identifier.tryParse(nbt.getString("id"));
    }

    public static int getLevelFromNbt(NbtCompound nbt) {
        return MathHelper.clamp(nbt.getInt("lvl"), 0, 255);
    }

    public static int getLevel(Enchantment enchantment, ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Identifier identifier = getEnchantmentId(enchantment);
            NbtList nbtList = stack.getEnchantments();

            for(int i = 0; i < nbtList.size(); ++i) {
                NbtCompound nbtCompound = nbtList.getCompound(i);
                Identifier identifier2 = getIdFromNbt(nbtCompound);
                if (identifier2 != null && identifier2.equals(identifier)) {
                    return getLevelFromNbt(nbtCompound);
                }
            }

            return 0;
        }
    }

    @FunctionalInterface
    interface Consumer {
        void accept(LostWorldEnchantment enchantment, int level, ItemStack itemStack);
    }
}
