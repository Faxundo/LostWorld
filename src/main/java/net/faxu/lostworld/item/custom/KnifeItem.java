package net.faxu.lostworld.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KnifeItem extends SwordItem {

    public KnifeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
            if (state.isOf(Blocks.SUGAR_CANE)) {
                stack.damage(1, miner, (e) -> {
                    e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);});
            }
        return super.postMine(stack, world, state, pos, miner);
    }
}
