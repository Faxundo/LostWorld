package net.faxu.lostworld.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.faxu.lostworld.LostWorld;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup LOSTWORLD = FabricItemGroupBuilder.build(
            new Identifier(LostWorld.MOD_ID, "lost_world"), () -> new ItemStack(ModItems.LOSTBOT));
}
