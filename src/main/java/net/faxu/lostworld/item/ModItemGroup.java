package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    //Create a new Tab group for creative mode
    public static final ItemGroup LOSTWORLD = FabricItemGroupBuilder.create(
            new Identifier(LostWorld.MOD_ID, "lost_world"))
            .icon(() -> new ItemStack(ModItems.LOSTBOT))
            .appendItems(stacks -> { //Index
                stacks.add(0, new ItemStack(ModItems.FIBER));
                stacks.add(1, new ItemStack(ModItems.BANDAGE));
                stacks.add(2, new ItemStack(ModItems.RATION));
                stacks.add(3, new ItemStack(ModItems.FLINT_KNIFE));
                stacks.add(4, new ItemStack(ModItems.IRON_KNIFE));
                stacks.add(5, new ItemStack(ModItems.DIAMOND_KNIFE));
                stacks.add(6, new ItemStack(ModItems.NETHERITE_KNIFE));
                stacks.add(7, new ItemStack(ModItems.POISON_BOTTLE));
                stacks.add(8, new ItemStack(ModItems.FLINT_KNIFE_POISONED));
                stacks.add(9, new ItemStack(ModItems.IRON_KNIFE_POISONED));
                stacks.add(10, new ItemStack(ModItems.DIAMOND_KNIFE_POISONED));
                stacks.add(11, new ItemStack(ModItems.NETHERITE_KNIFE_POISONED));
                stacks.add(12, new ItemStack(ModItems.IRON_BUTCHER_KNIFE));
                stacks.add(13, new ItemStack(ModItems.DIAMOND_BUTCHER_KNIFE));
                stacks.add(14, new ItemStack(ModItems.NETHERITE_BUTCHER_KNIFE));
                stacks.add(15, new ItemStack(ModItems.DICE));
                stacks.add(16, new ItemStack(ModItems.SALT));
                stacks.add(17, new ItemStack(ModBlocks.SALT_BLOCK));
                stacks.add(18, new ItemStack(ModBlocks.TIN_ORE));
                stacks.add(19, new ItemStack(ModBlocks.TIN_BLOCK));
                stacks.add(20, new ItemStack(ModBlocks.TIN_ORE_DEEPSLATE));
                stacks.add(21, new ItemStack(ModItems.TIN));
                stacks.add(22, new ItemStack(ModItems.DRIED_MEAT));
                stacks.add(23, new ItemStack(ModItems.COPPER_HELMET));
                stacks.add(24, new ItemStack(ModItems.COPPER_CHESTPLATE));
                stacks.add(25, new ItemStack(ModItems.COPPER_LEGGINGS));
                stacks.add(26, new ItemStack(ModItems.COPPER_BOOTS));
                stacks.add(27, new ItemStack(ModItems.WOOD_CLUB));
                stacks.add(28, new ItemStack(ModItems.BONE_CLUB));
                stacks.add(29, new ItemStack(ModItems.IRON_CLUB));
                stacks.add(30, new ItemStack(ModItems.DIAMOND_CLUB));
                stacks.add(31, new ItemStack(ModItems.NETHERITE_CLUB));
                stacks.add(32, new ItemStack(ModItems.TIN_INGOT));
                stacks.add(33, new ItemStack(ModItems.BRONZE_INGOT));
                stacks.add(34, new ItemStack(ModItems.STEEL_INGOT));
                stacks.add(35, new ItemStack(ModItems.BITTER_ROOT));
                stacks.add(36, new ItemStack(ModItems.BITTER_ROOT_SEEDS));
                stacks.add(37, new ItemStack(ModItems.WILD_BOAR_SPAWN_EGG));
                stacks.add(38, new ItemStack(ModItems.BOAR_TUSK));
                stacks.add(39, new ItemStack(ModItems.PEBBLE));
                stacks.add(40, new ItemStack(ModItems.WOOD_SLINGSHOT));
                stacks.add(41, new ItemStack(ModItems.IRON_SLINGSHOT));
                stacks.add(42, new ItemStack(ModItems.COPPER_ARROW));
                stacks.add(43, new ItemStack(ModBlocks.TANNING_RACK));
                stacks.add(44, new ItemStack(ModItems.LEATHER_STRIP));
                stacks.add(45, new ItemStack(ModItems.TANNED_LEATHER));
                stacks.add(46, new ItemStack(ModItems.TANNED_LEATHER_STRIP));
            })
            .build();
}