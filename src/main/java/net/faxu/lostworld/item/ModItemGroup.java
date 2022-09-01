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
            .build();
//            .appendItems(stacks -> {
//                stacks.add(48, new ItemStack(ModItems.IRON_SHURIKEN));
//                stacks.add(50, new ItemStack(ModItems.IRON_SPEAR));
//            })
//            .build();
}