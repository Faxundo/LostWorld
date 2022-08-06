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
                stacks.add(4, new ItemStack(ModItems.POISON_BOTTLE));
                stacks.add(5, new ItemStack(ModItems.FLINT_KNIFE_POISONED));
                stacks.add(6, new ItemStack(ModItems.BUTCHER_KNIFE));
                stacks.add(7, new ItemStack(ModItems.DICE));
                stacks.add(7, new ItemStack(ModItems.SALT));
                stacks.add(9, new ItemStack(ModBlocks.SALT_BLOCK));
                stacks.add(10, new ItemStack(ModBlocks.TIN_ORE));
                stacks.add(11, new ItemStack(ModBlocks.TIN_BLOCK));
                stacks.add(12, new ItemStack(ModBlocks.TIN_ORE_DEEPSLATE));
                stacks.add(13, new ItemStack(ModItems.TIN));
                stacks.add(14, new ItemStack(ModItems.DRIED_MEAT));
                stacks.add(15, new ItemStack(ModItems.COPPER_HELMET));
                stacks.add(16, new ItemStack(ModItems.COPPER_CHESTPLATE));
                stacks.add(17, new ItemStack(ModItems.COPPER_LEGGINGS));
                stacks.add(18, new ItemStack(ModItems.COPPER_BOOTS));
                stacks.add(19, new ItemStack(ModItems.WOOD_CLUB));
                stacks.add(20, new ItemStack(ModItems.BONE_CLUB));
            })
            .build();
}