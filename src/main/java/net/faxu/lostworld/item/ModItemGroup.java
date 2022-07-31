package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.faxu.lostworld.LostWorld;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup LOSTWORLD = FabricItemGroupBuilder.create(
            new Identifier(LostWorld.MOD_ID, "lost_world"))
            .icon(() -> new ItemStack(ModItems.LOSTBOT))
            .appendItems(stacks -> {
                stacks.add(0, new ItemStack(ModItems.FIBER));
                stacks.add(1, new ItemStack(ModItems.BANDAGE));
                stacks.add(2, new ItemStack(ModItems.FLINT_KNIFE));
                stacks.add(3, new ItemStack(ModItems.DICE));
            })
            .build();
}