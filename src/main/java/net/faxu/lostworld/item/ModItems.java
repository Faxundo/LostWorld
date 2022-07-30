package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.item.custom.DiceItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item FIBER = registerItem("fiber",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item BANDAGE = registerItem("bandage",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item LOSTBOT = registerItem("lostbot",
            new Item(new FabricItemSettings()));
    public static final Item FLINT_KNIFE = registerItem("flint_knife",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item DICE = registerItem("dice",
            new DiceItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).maxCount(1)));

    private static Item registerItem (String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(LostWorld.MOD_ID, name), item);
    }
    public static void registerModItems() {
        LostWorld.LOGGER.debug("Regisering Mod Items for " + LostWorld.MOD_ID);
    }
}
