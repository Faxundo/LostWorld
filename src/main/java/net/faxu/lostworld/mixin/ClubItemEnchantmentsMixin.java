package net.faxu.lostworld.mixin;

import net.faxu.lostworld.item.custom.ClubItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.enchantment.LuckEnchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class ClubItemEnchantmentsMixin {

    @Shadow
    @Final
    public EnchantmentTarget type;

    @Inject(method = "isAcceptableItem", at = @At(value = "HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (stack.getItem() instanceof ClubItem) {
            if (enchantment instanceof KnockbackEnchantment) {
                cir.setReturnValue(true);
            } else if (enchantment instanceof LuckEnchantment && type == EnchantmentTarget.WEAPON) {
                cir.setReturnValue(true);
            }
        }
    }
}
