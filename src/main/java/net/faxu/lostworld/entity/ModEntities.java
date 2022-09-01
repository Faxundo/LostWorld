package net.faxu.lostworld.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.entity.custom.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.example.registry.EntityRegistryBuilder;
import software.bernie.geckolib3.GeckoLib;

public class ModEntities {
    public static final EntityType<WildBoarEntity> WILD_BOAR = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(LostWorld.MOD_ID, "wild_boar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WildBoarEntity::new)
                    .dimensions(EntityDimensions.fixed(0.85f, 0.95f)).build());
    public static EntityType<PebbleEntity> PEBBLE = buildEntity(PebbleEntity::new, PebbleEntity.class, 0.25F,
            0.25F, SpawnGroup.MISC);
    public static final EntityType<CopperArrowEntity> COPPER_ARROW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(LostWorld.MOD_ID, "copper_arrow"),
            FabricEntityTypeBuilder.<CopperArrowEntity>create(SpawnGroup.MISC, CopperArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());
    public static final EntityType<IronShurikenEntity> IRON_SHURIKEN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(LostWorld.MOD_ID, "iron_shuriken"),
            FabricEntityTypeBuilder.<IronShurikenEntity>create(SpawnGroup.MISC, IronShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
    public static final EntityType<IronSpearEntity> IRON_SPEAR = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(LostWorld.MOD_ID, "iron_spear"),
            FabricEntityTypeBuilder.<IronSpearEntity>create(SpawnGroup.MISC, IronSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F))
                    .build());

    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass,
                                                               float width, float height, SpawnGroup group) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            String name = entityClass.getSimpleName().toLowerCase();
            return EntityRegistryBuilder.<T>createBuilder(new Identifier(GeckoLib.ModID, name)).entity(entity)
                    .category(group).dimensions(EntityDimensions.changing(width, height)).build();
        }
        return null;
    }
}
