package net.faxu.lostworld.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//New object item
public class DiceItem extends Item {
    public DiceItem(Settings settings) {
        super(settings);
    }

    //Functionality
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 20);
        }
        return super.use(world, user, hand);
    }
    //Method for text lore
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.lostworld.dice_info").formatted(Formatting.GREEN));
        } else {
            tooltip.add(Text.translatable("item.lostworld.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
    //Method for show number
    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(Text.translatable("item.lostworld.dice_text" + getRandomNumber()));
    }
    //Method for generate random number
    private int getRandomNumber() {
        return Random.createLocal().nextInt(6);
    }
}
