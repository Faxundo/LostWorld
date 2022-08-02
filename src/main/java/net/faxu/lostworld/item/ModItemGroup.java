package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.faxu.lostworld.LostWorld;
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
                stacks.add(6, new ItemStack(ModItems.DICE));
            })
            .build();
}