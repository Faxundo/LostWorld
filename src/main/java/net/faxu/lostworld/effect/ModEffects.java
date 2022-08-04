package net.faxu.lostworld.effect;

import net.faxu.lostworld.LostWorld;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect BLEEDING;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(LostWorld.MOD_ID, name),
                new BleedingEffect(StatusEffectCategory.HARMFUL, 4393481));

    }

    public static void registerEffects(){
        BLEEDING = registerStatusEffect("bleeding");
    }
}
