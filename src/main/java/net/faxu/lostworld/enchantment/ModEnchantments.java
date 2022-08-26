package net.faxu.lostworld.enchantment;

import net.faxu.lostworld.LostWorld;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment GUARD = register("guard", new GuardEnchantment());
    public static Enchantment CAPTURE = register("capture", new CaptureEnchantment());
    public static Enchantment BLEEDING = register("bleeding", new BleedingEnchantment());
    public static Enchantment MIGHTY = register("mighty", new MightyEnchantment());
    public static Enchantment BUTCHERING = register("butchering", new ButcheringEnchantment());
    public static Enchantment RUSTY = register("curse_of_rusty", new RustyCurse());
    public static Enchantment THORNYROSES = register("curse_of_thorny_roses", new ThornyRosesCurse());

    public static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(LostWorld.MOD_ID, name), enchantment);
    }
    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + LostWorld.MOD_ID);
    }
}
