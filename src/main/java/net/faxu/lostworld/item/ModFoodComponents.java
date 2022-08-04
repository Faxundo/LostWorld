package net.faxu.lostworld.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    //New Foods
    public static final FoodComponent RATION =
            new FoodComponent.Builder().hunger(10).saturationModifier(0.8f).build();
    public static final FoodComponent DRIED_MEAT =
            new FoodComponent.Builder().hunger(5).saturationModifier(7).build();
}
