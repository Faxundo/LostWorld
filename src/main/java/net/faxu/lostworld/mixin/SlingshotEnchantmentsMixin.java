package net.faxu.lostworld.mixin;

import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.item.custom.SlingshotItem;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class SlingshotEnchantmentsMixin {
    @Shadow
    @Final
    public EnchantmentTarget type;

    @Inject(method = "isAcceptableItem", at = @At(value = "HEAD"), cancellable = true)
    public void onIsAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (stack.getItem() instanceof SlingshotItem) {
            if (enchantment instanceof PowerEnchantment) {
                cir.setReturnValue(true);
            } else if (enchantment instanceof PunchEnchantment && LostWorld.CONFIG.SlingshotUsePunchEnchantment) {
                cir.setReturnValue(true);
            } else if (enchantment instanceof InfinityEnchantment) {
                cir.setReturnValue(false);
            }
        }
    }
}
