package net.faxu.lostworld.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<TanningRackBlockEntity> TANNING_RACK;

    public static void registerAllBlockEntities(){
        TANNING_RACK = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(LostWorld.MOD_ID, "tanning_rack"),
                FabricBlockEntityTypeBuilder.create(TanningRackBlockEntity::new,
                        ModBlocks.TANNING_RACK).build(null));
    }
}
