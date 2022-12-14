package net.faxu.lostworld.item.custom;

import net.faxu.lostworld.effect.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class BandageItem extends Item {
    public BandageItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            user.heal(4.0f);
            user.getItemCooldownManager().set(this, 70);
            stack.decrement(1);
            if (user.hasStatusEffect(ModEffects.BLEED)) {
                user.removeStatusEffect(ModEffects.BLEED);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.lostworld.bandage_text"));
        tooltip.add(Text.translatable("item.lostworld.bandage_text2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
