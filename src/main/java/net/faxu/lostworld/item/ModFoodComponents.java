package net.faxu.lostworld.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    //New Foods
    public static final FoodComponent RATION =
            new FoodComponent.Builder().hunger(10).saturationModifier(0.8f).build();
    public static final FoodComponent DRIED_MEAT =
            new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build();
    public static final FoodComponent BITTER_ROOT =
            new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
    public static final FoodComponent RAW_MEAT =
            new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build();
}
