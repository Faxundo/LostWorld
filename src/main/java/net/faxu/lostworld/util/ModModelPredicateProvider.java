package net.faxu.lostworld.util;


import net.faxu.lostworld.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels(){
        registerSlingshot(ModItems.SLINGSHOT);
        registerSpear(ModItems.IRON_SPEAR);
    }

    private static void registerSlingshot(Item bow) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }

    private static void registerSpear(Item spear) {
        ModelPredicateProviderRegistry.register(spear, new Identifier("throw"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(spear, new Identifier("throwing",
                "iron_spear"), (stack, world, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
    }
}
