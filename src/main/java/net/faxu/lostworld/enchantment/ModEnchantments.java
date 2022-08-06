package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.item.custom.ClubItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment MASSACRE = register("massacre", new MassacreEnchantment(
            Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment CAPTURE = register("capture", new CaptureEnchantment(
            Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment BLEEDING = register("bleeding", new BleedingEnchantment(
            Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(LostWorld.MOD_ID, name), enchantment);
    }
    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + LostWorld.MOD_ID);
    }
}
