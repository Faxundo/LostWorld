package net.faxu.lostworld.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class TanningRackRecipe implements Recipe<SimpleInventory> {

    private final Identifier id;
    private final ItemStack result;
    private final DefaultedList<Ingredient> items;

    public TanningRackRecipe(Identifier id, ItemStack result, DefaultedList<Ingredient> items) {
        this.id = id;
        this.result = result;
        this.items = items;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (items.get(0).test(inventory.getStack(1))) {
            return items.get(1).test(inventory.getStack(2));
        }
        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return result.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TanningRackRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "tanning_rack";
    }

    public static class Serializer implements RecipeSerializer<TanningRackRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "tanning_rack";

        @Override
        public TanningRackRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new TanningRackRecipe(id, output, inputs);
        }

        @Override
        public TanningRackRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new TanningRackRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, TanningRackRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
