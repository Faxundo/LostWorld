package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.block.ModBlocks;
import net.faxu.lostworld.entity.ModEntities;
import net.faxu.lostworld.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
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
    public static final Item TIN_INGOT = registerItem("tin_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item BOAR_TUSK = registerItem("boar_tusk",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item STRIP_LEATHER = registerItem("strip_leather",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    //FOOD
    public static final Item RATION = registerItem("ration",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).food(ModFoodComponents.RATION)));
    public static final Item DRIED_MEAT = registerItem("dried_meat",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).food(ModFoodComponents.DRIED_MEAT)));
    public static final Item BITTER_ROOT = registerItem("bitter_root",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).food(ModFoodComponents.BITTER_ROOT)));
    public static final Item RAW_MEAT = registerItem("raw_meat",
            new Item(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).food(ModFoodComponents.RAW_MEAT)));
    //SEEDS
    public static final Item BITTER_ROOT_SEEDS = registerItem("bitter_root_seeds",
            new AliasedBlockItem(ModBlocks.BITTER_ROOT_CROP, new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
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
    public static final Item IRON_KNIFE = registerItem("iron_knife",
            new KnifeItem(ToolMaterials.IRON, 0, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item IRON_KNIFE_POISONED = registerItem("iron_knife_poisoned",
            new ModSwordPoisonedItem(ToolMaterials.IRON, 0, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item DIAMOND_KNIFE = registerItem("diamond_knife",
            new KnifeItem(ToolMaterials.DIAMOND, 0, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item DIAMOND_KNIFE_POISONED = registerItem("diamond_knife_poisoned",
            new ModSwordPoisonedItem(ToolMaterials.DIAMOND, 0, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item NETHERITE_KNIFE = registerItem("netherite_knife",
            new KnifeItem(ToolMaterials.NETHERITE, 0, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item NETHERITE_KNIFE_POISONED = registerItem("netherite_knife_poisoned",
            new ModSwordPoisonedItem(ToolMaterials.NETHERITE, 0, -2.0f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item IRON_BUTCHER_KNIFE = registerItem("iron_butcher_knife",
            new ButcherKnife(ToolMaterials.IRON, 1, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item DIAMOND_BUTCHER_KNIFE = registerItem("diamond_butcher_knife",
            new ButcherKnife(ToolMaterials.DIAMOND, 1, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item NETHERITE_BUTCHER_KNIFE = registerItem("netherite_butcher_knife",
            new ButcherKnife(ToolMaterials.NETHERITE, 1, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item WOOD_CLUB = registerItem("wood_club",
            new ClubItem(ToolMaterials.WOOD, 4, -2.6f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item BONE_CLUB = registerItem("bone_club",
            new ClubItem(ModToolMaterials.BONE, 5, -2.6f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item IRON_CLUB = registerItem("iron_club",
            new ClubItem(ToolMaterials.IRON, 4, -2.6f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item DIAMOND_CLUB = registerItem("diamond_club",
            new ClubItem(ToolMaterials.DIAMOND, 4, -2.6f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item NETHERITE_CLUB = registerItem("netherite_club",
            new ClubItem(ToolMaterials.NETHERITE, 4, -2.6f,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item WOOD_SLINGSHOT = registerItem("wood_slingshot",
            new SlingshotItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).maxDamage(300)));
    public static final Item IRON_SLINGSHOT = registerItem("iron_slingshot",
            new SlingshotItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD).maxDamage(600)));
    //PROJECTILE
    public static final Item PEBBLE = registerItem("pebble",
            new PebbleItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD), 0.6f));
    public static final Item COPPER_ARROW = registerItem("copper_arrow",
            new CopperArrowItem(new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    //ARMORS
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    //SPAWN EGGS
    public static final Item WILD_BOAR_SPAWN_EGG = registerItem("wild_boar_spawn_egg",
            new SpawnEggItem(ModEntities.WILD_BOAR, 0xbc9569, 0xffffdd, new FabricItemSettings().group(ModItemGroup.LOSTWORLD)));
    //BLOCKS


    //Register new Item
    private static Item registerItem (String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(LostWorld.MOD_ID, name), item);
    }
    //Message for the debug view
    public static void registerModItems() {
        LostWorld.LOGGER.debug("Registering Mod Items for " + LostWorld.MOD_ID);
    }
}
