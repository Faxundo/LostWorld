package net.faxu.lostworld.effect;

import net.faxu.lostworld.LostWorld;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect BLEED;
    public static StatusEffect STUN;
    public static StatusEffect SATISFACTION;
    public static StatusEffect FROZEN;

    public static StatusEffect registerBleed(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(LostWorld.MOD_ID, name),
                new BleedEffect(StatusEffectCategory.HARMFUL, 4393481));
    }
    public static StatusEffect registerStun(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(LostWorld.MOD_ID, name),
                new StunEffect(StatusEffectCategory.HARMFUL, 251255157));
    }
    public static StatusEffect registerSatisfaction(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(LostWorld.MOD_ID, name),
                new SatisfactionEffect(StatusEffectCategory.BENEFICIAL, 164255157));
    }
    public static StatusEffect registerFrozen(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(LostWorld.MOD_ID, name),
                new FrozenEffect(StatusEffectCategory.HARMFUL, 143204231));
    }



    public static void registerEffects(){
        BLEED = registerBleed("bleed");
        STUN = registerStun("stun");
        SATISFACTION = registerSatisfaction("satisfaction");
        FROZEN = registerFrozen("frozen");
    }
}
