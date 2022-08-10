package net.faxu.lostworld.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.entity.custom.WildBoarEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<WildBoarEntity> WILD_BOAR = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(LostWorld.MOD_ID, "wild_boar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WildBoarEntity::new)
                    .dimensions(EntityDimensions.fixed(0.85f, 0.95f)).build());
}
