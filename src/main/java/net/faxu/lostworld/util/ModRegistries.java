package net.faxu.lostworld.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.faxu.lostworld.entity.ModEntities;
import net.faxu.lostworld.entity.custom.WildBoarEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.WILD_BOAR, WildBoarEntity.setAttributes());
    }
}
