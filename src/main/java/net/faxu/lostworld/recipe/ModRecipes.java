package net.faxu.lostworld.recipe;

import net.faxu.lostworld.LostWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(LostWorld.MOD_ID, TanningRackRecipe.Serializer.ID),
                TanningRackRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(LostWorld.MOD_ID, TanningRackRecipe.Type.ID),
                TanningRackRecipe.Type.INSTANCE);
    }
}
