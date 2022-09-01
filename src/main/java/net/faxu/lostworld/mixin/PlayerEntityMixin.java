package net.faxu.lostworld.mixin;

import net.faxu.lostworld.util.LostWorldEnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void onTick(CallbackInfo ci) {
        LostWorldEnchantmentHelper.onSneaking((PlayerEntity) (Object)this);
    }

    @ModifyVariable(method = "attack",  ordinal = 1, at = @At(value = "CONSTANT", args = "floatValue=0.5F", ordinal = 0))
    public float onGetAttackDamage(float h, Entity target){
        return h + LostWorldEnchantmentHelper.getAttackDamage((PlayerEntity)(Object)this, target);
    }
}
