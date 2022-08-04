package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //ICON ITEM
    public static final Item LOSTBOT = registerItem("lostbot",
            new Item(new FabricItemSettings()));
    //MISC
    public static final Item FIBER = registerItem("fiber",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item POISON_BOTTLE = registerItem("poison_bottle",
            new PoisonItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).maxCount(3)));
    public static final Item SALT = registerItem("salt",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item TIN = registerItem("tin",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    //FOOD
    public static final Item RATION = registerItem("ration",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).food(ModFoodComponents.RATION)));
    public static final Item DRIED_MEAT = registerItem("dried_meat",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).food(ModFoodComponents.DRIED_MEAT)));
    //USE
    public static final Item DICE = registerItem("dice",
            new DiceItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).maxCount(1)));
    public static final Item BANDAGE = registerItem("bandage",
            new BandageItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).maxCount(16)));
    //TOOLS
    public static final Item FLINT_KNIFE = registerItem("flint_knife",
            new KnifeItem(ModToolMaterials.FLINT, 1, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item FLINT_KNIFE_POISONED = registerItem("flint_knife_poisoned",
            new ModSwordPoisonedItem(ModToolMaterials.FLINT, 1, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item BUTCHER_KNIFE = registerItem("butcher_knife",
            new ButcherKnifeItem(ToolMaterials.IRON, 1, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    //ARMORS

    //Register new Item
    private static Item registerItem (String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(LostWorld.MOD_ID, name), item);
    }
    //Message for the debug view
    public static void registerModItems() {
        LostWorld.LOGGER.debug("Registering Mod Items for " + LostWorld.MOD_ID);
    }
}
